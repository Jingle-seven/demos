package xz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xz.dao.UserMapper;
import xz.model.TUser;
import xz.util.Util;

import java.util.logging.Logger;

/**
 * Created by Jinhua on 2017/5/25 16:06.
 */
@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	UserMapper userDao;
	
	@RequestMapping(value="user",method =  RequestMethod.GET)
	public String findUser(ModelMap map) {
		map.addAttribute("allUser", userDao.selectAll());
		map.addAttribute("loggedUser", Util.getLoggedOnUser());
		return "user_list";
	}
	
	@RequestMapping(value="admin/user/add",method =  RequestMethod.GET)
	public String addUserPage() {
		return "user_add";
	}
	@RequestMapping(value="user/modify",method =  RequestMethod.GET)
	public String addUserPages(ModelMap map) {
		map.put("user", Util.getLoggedOnUser());
		return "user_modify";
	}
	@RequestMapping(value="admin/user/add",method =  RequestMethod.POST)
	public String addUser(TUser user, ModelMap map) {
		user.setId(System.currentTimeMillis());
		try{
			Logger.getAnonymousLogger().info("受影响记录:" + userDao.insert(user));
		}catch (DuplicateKeyException e){
			map.addAttribute("msg", "账号已被注册,请换一个账号");
			return "user_add";
		}
		map.addAttribute("allUser", userDao.selectAll());
		map.addAttribute("loggedUser", Util.getLoggedOnUser());
		return "user_list";
	}
	@RequestMapping(value="user/modify",method =  RequestMethod.POST)
	public String modifyUser(TUser user,ModelMap map) {
		TUser loggedUser = Util.getLoggedOnUser();
		loggedUser.setAccount(user.getAccount())
				.setPassword(user.getPassword())
				.setName(user.getName());
		int resCode = userDao.updateById(loggedUser);
		map.put("user", loggedUser);
		if(resCode==1) {
			map.put("msg", "修改成功");
		}else {
			map.put("msg", "修改失败");
		}
		return "user_modify";
	}
	@RequestMapping(value="admin/user/delete",method =  RequestMethod.POST)
	public String deleteUser(TUser user,ModelMap map) {
		userDao.deleteByPrimaryKey(user.getId());
		map.addAttribute("allUser", userDao.selectAll());
		map.addAttribute("loggedUser",Util.getLoggedOnUser());
		return "user_list";
	}
}
