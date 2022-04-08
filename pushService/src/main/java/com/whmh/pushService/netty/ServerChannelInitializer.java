package com.whmh.pushService.netty;

import com.whmh.pushService.netty.handler.NetMsgHeaderHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 服务器端handler的初始化。
 */
@Qualifier("serverChannelInitializer")
@Service
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        /*Netty提供的日志打印Handler，可以展示发送接收出去的字节*/
        ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));

        /*剥离接收到的消息的长度字段，拿到实际的消息报文的字节数组*/
        ch.pipeline().addLast(new NetMsgHeaderHandler());

    }
}
