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
import xz.dao.ISpanDao;
import xz.model.Span;
import xz.model.TopoLink;
import xz.model.TopoNode;
import xz.util.XKit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Created by xxz on 8/8/16.
 */

@RestController
@RequestMapping("/api")
public class JingleApi {
    
    @Value("${jingle.ui.port}")
    int port;
    @Autowired
    ISpanDao spanDao;
    
    @RequestMapping(value = "/{num1}", method = RequestMethod.GET)
    public ResponseEntity<String> getUiPort(
            @PathVariable int num1,
            @RequestParam(required = false) int num) {
        num1 = num1/num;
        Logger l = Logger.getLogger("haha");
//        l.info(port);
        return cacheResponse("hello,pathNum by num is " + num1);
    }
    @RequestMapping(value = "/topo", method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> topo() {
	
		List<Span> spans = spanDao.findAll();
		Map<String,TopoNode> nodes = new HashMap<>(32);
		Map<String,TopoLink> links = new HashMap<>(32);
		for (Span span : spans) {
			TopoNode child = new TopoNode(XKit.longToIp(span.getEndpointIpv4()),span.getEndpointServiceName());
			addNode(nodes, child);
			if(span.getParentIp()!=null || span.getParentEndpointName()!=null) {
				TopoNode parent = new TopoNode(XKit.longToIp(span.getParentIp()), span.getParentEndpointName());
//				addNode(nodeNames, parent);
				nodes.get(child.getToken()).setParent(nodes.get(parent.getToken()));
				TopoLink link = new TopoLink(parent.token,child.token);
				addLink(links,link);
				//一个结点可以派生出多个结点,所以同一结点parent和child计数可能不一样
			}
		}
		nodes.values().forEach(TopoNode::genDepth);
		Map<String,Object> dataMap = new HashMap<>();
		dataMap.put("node",nodes.values());
		dataMap.put("link",links.values());
		String[] meta = {"node:"+nodes.size(),"link:"+links.size()};
        return cacheResponse(dataMap);
    }
	
	private TopoNode addNode(Map<String, TopoNode> nodes, TopoNode parent) {
		TopoNode node = nodes.get(parent.token);
		return node==null ? nodes.put(parent.token,parent) : node.addOnce();
	}
	private TopoLink addLink(Map<String, TopoLink> links, TopoLink link) {
		String linkToken = link.genToken();
		TopoLink node = links.get(linkToken);
		return node==null ? links.put(linkToken,link) : node.addOnce();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String[]> test() {
        String[] leaves = {"leaf_1","leaf_2","leaf_3","leaf_4"};
        return cacheResponse(leaves);
    }
    //缓存这个ResponseEntity300秒
    private <T> ResponseEntity<T> cacheResponse(T value) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS).mustRevalidate());
        return builder.body(value);
    }
}
