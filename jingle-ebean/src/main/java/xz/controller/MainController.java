package xz.controller;

import io.ebean.Ebean;
import io.ebean.ExpressionList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xz.model.User;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "jq-01-ajax.html";
    }
}
