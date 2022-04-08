package com.whmh.pushService.netty.handler;

import com.sun.deploy.config.ClientConfig;
import com.whmf.mars.chat.proto.Chat;
import com.whmf.mars.chat.proto.Main;
import com.whmh.pushService.netty.TopicChats;
import com.whmh.pushService.netty.utils.LogUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import jdk.internal.util.xml.impl.Input;
import org.apache.commons.io.IOUtils;


import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;


public class NetMsgHeaderHandler extends ChannelInboundHandlerAdapter {

    public static Logger logger = Logger.getLogger(NetMsgHeaderHandler.class.getName());

    private static Map<Integer, String> CMD_PATH_MAP = new HashMap<>();

    static {
        CMD_PATH_MAP.put(Main.CmdID.CMD_ID_HELLO_VALUE, "mars/hello");
        CMD_PATH_MAP.put(Main.CmdID.CMD_ID_SEND_MESSAGE_VALUE, "/mars/sendmessage");
        CMD_PATH_MAP.put(Main.CmdID.CMD_ID_HELLO2_VALUE, "/mars/hello2");
    }

    private ConcurrentHashMap<ChannelHandlerContext, Long> linkTimeout = new ConcurrentHashMap<>();
    private ContextTimeoutChecker checker;

    public NetMsgHeaderHandler() {
        super();

        checker = new ContextTimeoutChecker();
        Timer timer = new Timer();
        timer.schedule(checker, 15 * 60 * 1000, 15 * 60 * 1000);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("连接激活！");
        logger.info("client connected! " + ctx.toString());
        linkTimeout.put(ctx, System.currentTimeMillis());
        TopicChats.getInstance().joinTopic(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            logger.info("解析数据！");
            // decode request
            final NetMsgHeader msgXp = new NetMsgHeader();
            final InputStream socketInput = new ByteBufInputStream((ByteBuf) msg);
            boolean ret = msgXp.decode(socketInput);
            IOUtils.closeQuietly(socketInput);

            if(!ret) return;

            linkTimeout.remove(ctx);
            linkTimeout.put(ctx, System.currentTimeMillis());
            logger.info(LogUtils.format("client req, cmdId=%d, seq=%d", msgXp.cmdId, msgXp.seq));

//            final ProxySession proxySession = ProxySession.Manager.get(ctx);
//            if (proxySession == null) {
//            }

            String webCgi = CMD_PATH_MAP.get(msgXp.cmdId);
            switch (msgXp.cmdId) {
                case Main.CmdID.CMD_ID_HELLO_VALUE:
                    InputStream requestDataStream = new ByteArrayInputStream(msgXp.body);
                    InputStream inputStream = doHttpRequest(webCgi, requestDataStream);
                    if (inputStream != null) {
                        msgXp.body = IOUtils.toByteArray(inputStream);
                        IOUtils.closeQuietly(requestDataStream);
                        byte[] respBuf = msgXp.encode();
                        logger.info(LogUtils.format( "client resp, cmdId=%d, seq=%d, resp.len=%d", msgXp.cmdId, msgXp.seq, msgXp.body == null ? 0 : msgXp.body.length));
                        ctx.writeAndFlush(ctx.alloc().buffer().writeBytes(respBuf));
                    }
                    else {

                    }
                    break;
                case Main.CmdID.CMD_ID_HELLO2_VALUE:
                    requestDataStream = new ByteArrayInputStream(msgXp.body);

                    inputStream = doHttpRequest(webCgi, requestDataStream);
                    if (inputStream != null) {
                        msgXp.body = IOUtils.toByteArray(inputStream);
                        IOUtils.closeQuietly(requestDataStream);
                        byte[] respBuf = msgXp.encode();
                        logger.info(LogUtils.format("client resp, cmdId=%d, seq=%d, resp.len=%d", msgXp.cmdId, msgXp.seq, msgXp.body == null ? 0 : msgXp.body.length));
                        ctx.writeAndFlush(ctx.alloc().buffer().writeBytes(respBuf));
                    }
                    else {

                    }
                    break;
                case Main.CmdID.CMD_ID_SEND_MESSAGE_VALUE:
                    requestDataStream = new ByteArrayInputStream(msgXp.body);

                    inputStream = doHttpRequest(webCgi, requestDataStream);
                    if (inputStream != null) {
                        msgXp.body = IOUtils.toByteArray(inputStream);
                        Chat.SendMessageResponse response = Chat.SendMessageResponse.parseFrom(msgXp.body);
                        if (response != null && response.getErrCode() == Chat.SendMessageResponse.Error.ERR_OK_VALUE) {
//                            TopicChats.getInstance().pushMessage(response.getTopic(), response.getText(), response.getFrom(), ctx);
                        }
                        IOUtils.closeQuietly(requestDataStream);
                        byte[] respBuf = msgXp.encode();
                        logger.info(LogUtils.format("client resp, cmdId=%d, seq=%d, resp.len=%d", msgXp.cmdId, msgXp.seq, msgXp.body == null ? 0 : msgXp.body.length));
                        ctx.writeAndFlush(ctx.alloc().buffer().writeBytes(respBuf));
                    }
                    else {

                    }
                    break;
                case NetMsgHeader.CMDID_NOOPING:
                    byte[] respBuf = msgXp.encode();
                    logger.info(LogUtils.format("client resp, cmdId=%d, seq=%d, resp.len=%d", msgXp.cmdId, msgXp.seq, msgXp.body == null ? 0 : msgXp.body.length));
                    ctx.writeAndFlush(ctx.alloc().buffer().writeBytes(respBuf));
                    break;
                default:
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * redirect request to webserver
     *  相当于请求消息
     * @param path
     * @param data
     * @return
     */
    private InputStream doHttpRequest(String path, InputStream data) throws IOException {
        // 通过网络请求获取二进制数据。
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders requestHeaders= new HttpHeaders();
        requestHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setBufferRequestBody(true);
        restTemplate.setRequestFactory(requestFactory);

        // 请求提
        HttpEntity<byte[]> requestEntity = new HttpEntity<byte[]>(IOUtils.toByteArray(data), requestHeaders);
        // 消息转换
        ProtobufHttpMessageConverter converter = new ProtobufHttpMessageConverter();

        converter.setSupportedMediaTypes(
                Arrays.asList(new MediaType[]{MediaType.APPLICATION_OCTET_STREAM}));
        restTemplate.getMessageConverters().add(converter);

        ResponseEntity<byte[]> responseEntityResponseEntity = restTemplate.postForEntity("http://localhost:8080/" + path, requestEntity, byte[].class);


        return new ByteArrayInputStream(responseEntityResponseEntity.getBody());
    }

    /**
     *
     */
    public class ContextTimeoutChecker extends TimerTask {

        @Override
        public void run() {
            logger.info(LogUtils.format("check longlink alive per 15 minutes, " + this));
            for (ChannelHandlerContext context : linkTimeout.keySet()) {
                if (System.currentTimeMillis() - linkTimeout.get(context) > 15 * 60 * 1000) {
//                    TopicChats.getInstance().leftTopic(context);
                    linkTimeout.remove(context);
                    logger.info(LogUtils.format("%s expired, deleted.", context.channel().toString()));
                }
            }
        }
    }
}
