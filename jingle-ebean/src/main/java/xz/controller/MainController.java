package xz.controller;

import io.ebean.Ebean;
import org.springframework.web.bind.annotation.*;
import xz.model.User;

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

    @RequestMapping(value = "find-by-no-id", method = RequestMethod.GET,produces = "application/json")
    public List<User> test3(@RequestParam Long id){

        return Ebean.find(User.class).where().ne("id",id).findList();
    }
}
