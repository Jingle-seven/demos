package xz.controller;

import io.ebean.Ebean;
import io.ebean.ExpressionList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xz.config.ErrorPageConfig;
import xz.model.User;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String root(){
        return "/index";
    }
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        System.out.println("index !");
        return "/page/index.html";
    }

    /**
     * 处理ErrorPageConfig配置过来的错误请求
     * {@link ErrorPageConfig#containerCustomizer()}
     */
    @RequestMapping(value = "404",method = RequestMethod.GET)
    public String error(){
        System.out.println("An error occurred !");
        return "/page/error.html";
    }
}
