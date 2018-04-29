package xz.controller;

import io.ebean.Ebean;
import io.ebean.ExpressionList;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.*;
import xz.model.User;
import xz.util.XKit;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin(origins = "*")
public class UserController {

	@RequestMapping(value = "find-by-name", method = GET,produces = "application/json")
	public User test1(@RequestParam String name){
        User user = Ebean.find(User.class)
                .where().eq("name", name)
                .findOne();
        return user;
	}
    @RequestMapping(value = "add", method = GET,produces = "application/json")
    public User test2(@RequestParam String name,String account){
	    User user = new User(name,account);
	    user.id = System.currentTimeMillis();
	    user.account += System.currentTimeMillis();
        Ebean.save(user);
        return user;
    }

    @RequestMapping(value = "find-by-name-auth", method = GET,produces = "application/json")
    public List<Object> test3(String name,Integer auth){
        ExpressionList<User> query = Ebean.find(User.class).where();
        query.eq("name",name);
        query.eq("authority",auth);
        List resList = new ArrayList();
        resList.addAll(query.findList());
        resList.addAll(query.findIds());
        resList.add(query.toString());//不知道该如何打印对应的sql
        return resList;
    }
    //get post 是默认支持的方法
    @RequestMapping(value = "user",produces = "application/json")
    public User user(){
        List<User> us = Ebean.find(User.class).findList();
        return us.size()==0?null:us.get(0);
    }
    @RequestMapping(value = "users", method = {GET,POST,PUT,DELETE,HEAD,OPTIONS,TRACE},produces = "application/json")
    public Map<String,Object> allUser(HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        Map<String,Object> resMap = new HashMap<>();
        Map<String,Object> reqMap = new HashMap<>();
        BeanUtils.populate(req,reqMap);
        reqMap = XKit.castToMap(req,true);
        List<User> users = Ebean.find(User.class).findList();
        System.out.println("fuck"+reqMap);
        resMap.put("data",users);
        resMap.put("req",reqMap);
        return resMap;
    }
}
