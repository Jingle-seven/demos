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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xz.biz.TUserBiz;
import xz.dao.ISpanDao;
import xz.model.Span;
import xz.model.TUser;
import xz.model.TopoLink;
import xz.model.TopoNode;
import xz.util.XKit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static xz.util.ButlerKit.cache;


/**
 * Created by xxz on 8/8/16.
 */

@RestController
@RequestMapping("/api")
public class JingleApi {
    
    @Value("${jingle.ui.port}")
    int port;
    @Autowired
    TUserBiz userBiz;
    
    @RequestMapping(value = "/{num1}", method = RequestMethod.GET)
    public ResponseEntity<String> getUiPort(
            @PathVariable int num1,
            @RequestParam(required = false) int num) {
        num1 = num1/num;
        Logger l = Logger.getLogger("haha");
//        l.info(port);
        return cache("hello,pathNum by num is " + num1);
    }
    @RequestMapping(value = "/topo", method = RequestMethod.GET)
    public ResponseEntity<Integer> topo() {

        return cache(userBiz.modifyUserName("Tom","Nancy"));
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String[]> test() {
        String[] leaves = {"leaf_1","leaf_2","leaf_3","leaf_4"};
        return cache(leaves);
    }
}
