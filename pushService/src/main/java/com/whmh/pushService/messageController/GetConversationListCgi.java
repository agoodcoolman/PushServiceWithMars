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


import com.whmf.mars.chat.proto.Main;
import com.whmh.pushService.netty.utils.LogUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

@RestController
@RequestMapping
public class GetConversationListCgi {


    Logger logger = Logger.getLogger(GetConversationListCgi.class.getName());

    private String[][] conDetails = new String[][]{
            new String[] {"Mars", "0", "STN Discuss"},
            new String[] {"Mars", "1", "Xlog Discuss"},
            new String[] {"Mars", "2", "SDT Discuss"}
    };


    @RequestMapping(value = "/mars/getconvlist", consumes = "application/octet-stream", produces = "application/octet-stream", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<byte[]> getconvlist(InputStream is) {
        try {
            final Main.ConversationListRequest request = Main.ConversationListRequest.parseFrom(is);

            logger.info(LogUtils.format("request from access_token=%s, type=%d", request.getAccessToken(), request.getType()));

            List<Main.Conversation> conversationList = null;
            if (request.getType() == Main.ConversationListRequest.FilterType.DEFAULT_VALUE) {
                conversationList = new LinkedList<Main.Conversation>();

                for (String[] conv : conDetails) {
                    conversationList.add(Main.Conversation.newBuilder()
                            .setName(conv[0])
                            .setTopic(conv[1])
                            .setNotice(conv[2])
                            .build());
                }
            }

            final Main.ConversationListResponse response = Main.ConversationListResponse.newBuilder()
                    .addAllList(conversationList).build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(response.toByteArray(), headers,
                    HttpStatus.OK);

            return result;

        } catch (Exception e) {
            logger.info(LogUtils.format("request invalid", e));
        }

        return null;
    }
}