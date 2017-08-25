package xz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import static xz.util.ButlerKit.cacheColumnAffected;


@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("login")
	public String login(@RequestParam(value = "uName",required = false) String uName,
						@RequestParam(value = "uid",required = false) String uid,
						ModelMap map) {
		
		if(uName==null || uid==null) {
			map.addAttribute("servant", "参数错误");
		}else {
			map.addAttribute("servant", uName + uid);
		}
		String[] servants = {"saber","lancer","archer","caster","rider","basaker","assassin"};
		map.addAttribute("allServant", servants);
		return "user_login";
	}
	
	@ResponseBody
	@RequestMapping("logout/{uName}")
	public String logout(@PathVariable String uName,
						@RequestParam(value = "uid",required = false) String uid) {
		return uName+" has logout "+ uid;
	}
	
	@RequestMapping("topo")
	public String topo(ModelMap map) {
		map.put("msg","拓扑图页面");
		return "topo";
	}
	@RequestMapping(value = "test1", method = RequestMethod.POST)
	public ResponseEntity<?> test(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println(req.getQueryString());
//        req.getParameterMap().forEach((k, v) -> System.out.println(k + ": " + v[0]));
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));
//            br = req.getReader();
			String str;
			StringBuilder wholeStr = new StringBuilder();
			while ((str = br.readLine()) != null) {
				wholeStr.append(str);
			}
			System.out.println("reader"+wholeStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cacheColumnAffected(req.getRequestURL().toString());
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.POST)
	public ResponseEntity<?> test(@ModelAttribute Map<String, String> map) {
		map.forEach((k, v) -> System.out.println(k + ": " + v));
		return cacheColumnAffected("");
	}
	
	@RequestMapping(value = "test3", method = RequestMethod.POST)
	public ResponseEntity<?> test(@RequestBody byte[] data){
		try {
			System.out.println(new String(data,"utf-8"));
			System.out.println(new String(data,"gbk"));
			System.out.println(new String(data,"gb2312"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cacheColumnAffected("");
	}
}
