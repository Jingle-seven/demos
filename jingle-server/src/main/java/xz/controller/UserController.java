package xz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xz.idao.mapper.AssetUserMapper;
import xz.model.AssetUser;
import xz.model.wrapper.UserWrapper;
import xz.util.ButlerKit;

import java.util.logging.Logger;

/**
 * Created by Jinhua on 2017/5/25 16:06.
 */
@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	AssetUserMapper userDao;
	
	@RequestMapping(value="user",method =  RequestMethod.GET)
	public String findUser(ModelMap map) {
		map.addAttribute("allUser", userDao.selectAll());
		map.addAttribute("loggedUser", ButlerKit.getLoggedOnUser());
		return "user_list";
	}
	
	@RequestMapping(value="admin/user/add",method =  RequestMethod.GET)
	public String addUserPage() {
		return "user_add";
	}
	@RequestMapping(value="user/modify",method =  RequestMethod.GET)
	public String addUserPages(ModelMap map) {
		map.put("user",ButlerKit.getLoggedOnUser());
		return "user_modify";
	}
	@RequestMapping(value="admin/user/add",method =  RequestMethod.POST)
	public String addUser(UserWrapper user, ModelMap map) {
		user.setId(System.currentTimeMillis());
		try{
			Logger.getAnonymousLogger().info("受影响记录:" + userDao.insert(user));
		}catch (DuplicateKeyException e){
			map.addAttribute("msg", "账号已被注册,请换一个账号");
			return "user_add";
		}
		map.addAttribute("allUser", userDao.selectAll());
		map.addAttribute("loggedUser", ButlerKit.getLoggedOnUser());
		return "user_list";
	}
	@RequestMapping(value="user/modify",method =  RequestMethod.POST)
	public String modifyUser(UserWrapper user, ModelMap map) {
		AssetUser loggedUser =ButlerKit.getLoggedOnUser();
		loggedUser.setAccount(user.getAccount());
		loggedUser.setPassword(user.getPassword());
		loggedUser.setName(user.getName());
		int resCode = userDao.updateByPrimaryKey(loggedUser);
		map.put("user", loggedUser);
		if(resCode==1) {
			map.put("msg", "修改成功");
		}else {
			map.put("msg", "修改失败");
		}
		return "user_modify";
	}
	@RequestMapping(value="admin/user/delete",method =  RequestMethod.POST)
	public String deleteUser(UserWrapper user,ModelMap map) {
		userDao.deleteByPrimaryKey(user.getId());
		map.addAttribute("allUser", userDao.selectAll());
		map.addAttribute("loggedUser",ButlerKit.getLoggedOnUser());
		return "user_list";
	}
}
