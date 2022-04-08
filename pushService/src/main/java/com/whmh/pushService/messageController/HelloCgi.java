package com.whmh.pushService.messageController;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.google.protobuf.ByteString;
import com.whmf.mars.chat.proto.Main;
import com.whmh.pushService.netty.utils.LogUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.logging.Logger;

@RestController
@RequestMapping
public class HelloCgi {

    Logger logger = Logger.getLogger(EchoCgi.class.getName());


    @RequestMapping(value = "/mars/hello2", consumes = "application/octet-stream", produces = "application/octet-stream")
    @ResponseBody
    public ResponseEntity<byte[]> hello(InputStream is) {
        try {
            final Main.HelloRequest request = Main.HelloRequest.parseFrom(is);

            logger.info(LogUtils.format("mars3 request from user=%s, text=%s", request.getUser(), request.getText()));
            if(request.hasDumpContent())
                logger.info(LogUtils.format("dump content length:%d", request.getDumpContent().size()));


            int retCode = 0;
            String errMsg = "hello mars";
            int size = 0;
            if("64KB".equals(request.getText()))
                size = 64*1024;
            if("128KB".equals(request.getText()))
                size = 128*1024;
            Main.HelloResponse response = null;
            if(size > 0) {
                byte[] dump = new byte[size];
                Random rand = new Random();
                rand.nextBytes(dump);
                response = Main.HelloResponse.newBuilder().setRetcode(retCode).setErrmsg(errMsg).setDumpContent(ByteString.copyFrom(dump)).build();
            } else {
                response = Main.HelloResponse.newBuilder().setRetcode(retCode).setErrmsg(errMsg).build();
            }
            final Main.HelloResponse resp = response;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(response.toByteArray(), headers,
                    HttpStatus.OK);

            return result;

        } catch (Exception e) {
            logger.info("error mars hello3");
            logger.info(LogUtils.format("%s", e));
        }

        return null;

    }
}
