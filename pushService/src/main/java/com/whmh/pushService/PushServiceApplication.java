package com.whmh.pushService;

import com.whmh.pushService.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PushServiceApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(PushServiceApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(PushServiceApplication.class, args);
		NettyServer tcpServer = context.getBean(NettyServer.class);
		tcpServer.start();
	}

}
