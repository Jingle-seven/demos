package xz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
