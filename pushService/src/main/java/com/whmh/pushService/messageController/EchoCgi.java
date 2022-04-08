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



import ch.qos.logback.core.util.FileUtil;
import com.whmf.mars.chat.proto.Main;
import com.whmh.pushService.netty.utils.LogUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;


@Controller
@RequestMapping
public class EchoCgi {

    Logger logger = Logger.getLogger(EchoCgi.class.getName());


    @RequestMapping(value = "/mars/hello", consumes = "application/octet-stream", produces = "application/octet-stream")
    @ResponseBody
    public ResponseEntity<byte[]> hello(InputStream is) {
        try {
            final Main.HelloRequest request = Main.HelloRequest.parseFrom(is);

            logger.info(LogUtils.format("request from user=%s, text=%s", request.getUser(), request.getText()));

            int retCode = 0;
            String errMsg = "congratulations, " + request.getUser();
            final Main.HelloResponse response = Main.HelloResponse.newBuilder().setRetcode(retCode).setErrmsg(errMsg).build();

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