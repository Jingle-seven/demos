package xz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class MainController {
	
	@RequestMapping("/login")
	public String login(ModelMap map) {
		// 加入一个属性，用来在模板中读取
		map.addAttribute("servant", "八傻卡");
		// return模板文件的名称，对应src/main/resources/templates/index.html
		return "userLogin";
	}
	
	@ResponseBody
	@RequestMapping("/logout/{uName}")
	public String index(@PathVariable String uName,
						@RequestParam(value = "uid",required = false) String uid) {
		return uName+" has logout "+ uid;
	}
}
