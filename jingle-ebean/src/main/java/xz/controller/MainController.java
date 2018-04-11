package xz.controller;

import io.ebean.Ebean;
import io.ebean.ExpressionList;
import org.springframework.web.bind.annotation.*;
import xz.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

	@RequestMapping(value = "find-by-name", method = RequestMethod.GET,produces = "application/json")
	public User test1(@RequestParam String name){
        User user = Ebean.find(User.class)
                .where().eq("name", name)
                .findOne();
        return user;
	}
    @RequestMapping(value = "add", method = RequestMethod.GET,produces = "application/json")
    public User test2(@RequestParam String name,String account){
	    User user = new User(name,account);
	    user.id = System.currentTimeMillis();
	    user.account += System.currentTimeMillis();
        Ebean.save(user);
        return user;
    }

    @RequestMapping(value = "find-by-name-auth", method = RequestMethod.GET,produces = "application/json")
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
}
