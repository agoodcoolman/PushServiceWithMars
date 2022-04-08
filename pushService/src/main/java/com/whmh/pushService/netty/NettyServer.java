package com.whmh.pushService.netty;

import com.whmh.pushService.netty.handler.NetMsgHeaderHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * netty的核心 启动
 */
@Component
public class NettyServer {

    public static Logger logger = Logger.getLogger(NettyServer.class.getName());

    @Autowired
    @Qualifier("serverChannelInitializer")
    ServerChannelInitializer serverChannelInitializer;

    int tcpPort = 9091;
    private Channel serverChannel;
    private ServerBootstrap serverBootstrap;

    public void start() throws Exception {
        logger.info("启动服务！");

        serverBootstrap = new ServerBootstrap();


        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();


        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(serverChannelInitializer);
        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();
        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
        for (@SuppressWarnings("rawtypes") ChannelOption option : keySet) {
            serverBootstrap.childOption(option, tcpChannelOptions.get(option));
        }

        serverChannel = serverBootstrap.bind(tcpPort).sync().channel().closeFuture().sync().channel();
    }

    @Bean(name = "tcpChannelOptions")
    public Map<ChannelOption<?>, Object> tcpChannelOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<ChannelOption<?>, Object>();
        options.put(ChannelOption.SO_KEEPALIVE, true);
        options.put(ChannelOption.SO_BACKLOG, 100);
        return options;
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannel.close();
        serverChannel.parent().close();
    }

    public ServerBootstrap getServerBootstrap() {
        return serverBootstrap;
    }

    public void setServerBootstrap(ServerBootstrap serverBootstrap) {
        this.serverBootstrap = serverBootstrap;
    }

}
