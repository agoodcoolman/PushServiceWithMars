/*
* Tencent is pleased to support the open source community by making Mars available.
* Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
*
* Licensed under the MIT License (the "License"); you may not use this file except in 
* compliance with the License. You may obtain a copy of the License at
* http://opensource.org/licenses/MIT
*
* Unless required by applicable law or agreed to in writing, software distributed under the License is
* distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
* either express or implied. See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.whmh.pushService.messageController;


import com.whmf.mars.chat.proto.Chat;
import com.whmh.pushService.netty.TopicChats;
import com.whmh.pushService.netty.utils.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Logger;

@RestController
@RequestMapping
public class SendMessageCgi {

    Logger logger = Logger.getLogger(SendMessageCgi.class.getName());


    @RequestMapping(value = "/mars/sendmessage", consumes = "application/octet-stream", produces = "application/octet-stream")
    @ResponseBody
    public ResponseEntity<byte[]> sendmessage(HttpServletRequest httprequest) {
        try {
            final Chat.SendMessageRequest request = Chat.SendMessageRequest.parseFrom(httprequest.getInputStream());

            logger.info(LogUtils.format("request from user=%s, text=%s to topic=%s", request.getFrom(), request.getText(), request.getTopic()));

            int retCode = Chat.SendMessageResponse.Error.ERR_OK_VALUE;
            String errMsg = "congratulations, " + request.getFrom();
            final Chat.SendMessageResponse response = Chat.SendMessageResponse.newBuilder()
                    .setErrCode(retCode)
                    .setErrMsg(errMsg)
                    .setFrom(request.getFrom())
                    .setText(request.getText())
                    .setTopic(request.getTopic())
                    .build();


            ConcurrentLinkedDeque<ChannelHandlerContext> channelHandlerContexts = TopicChats.getInstance().topicJoiners.get(request.getTopic());
            for (ChannelHandlerContext channelHandlerContext: channelHandlerContexts) {
                TopicChats.getInstance().pushMessage("0", "收到：" + request.getText(), request.getFrom(), channelHandlerContext);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(response.toByteArray(), headers,
                    HttpStatus.OK);
            return result;

        } catch (Exception e) {
            logger.info(LogUtils.format("%s", e));
        }

        return null;
    }
}