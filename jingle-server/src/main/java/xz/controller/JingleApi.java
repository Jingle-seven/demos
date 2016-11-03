/**
 * Copyright 2015-2016 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package xz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Created by xxz on 8/8/16.
 */

@RestController
@RequestMapping("/jingle")
public class JingleApi {
    
    @Value("${jingle.ui.port}")
    int port;
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> getTeams() {
        
        return cacheResponse("hello, the port is "+port);
    }
   
    //缓存这个ResponseEntity300秒
    private <T> ResponseEntity<T> cacheResponse(T value) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS).mustRevalidate());
        return builder.body(value);
    }
}
