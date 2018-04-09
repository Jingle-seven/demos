package xz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xz.dao.UserRepository;
import xz.model.User;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    UserRepository dao;

	@RequestMapping(value = "find-by-name", method = RequestMethod.GET,produces = "application/json")
	public User test1(@RequestParam String name){
        User user=dao.findByName(name);
        dao.findAll();
        dao.findOne(1l);
        dao.save(user);
        dao.delete(user);
        dao.count();
        dao.exists(1l);
        return user;
	}
    @RequestMapping(value = "find-all", method = RequestMethod.GET,produces = "application/json")
    public Page<User> test2(@RequestParam Integer page){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, 2, sort);
        return dao.findAll(pageable);
    }

    @RequestMapping(value = "find-by-id-auth", method = RequestMethod.GET,produces = "application/json")
    public List<User> test3(@RequestParam Long id, @RequestParam Integer auth){
        return dao.findByIdAndAuth(id,auth);
    }
}
