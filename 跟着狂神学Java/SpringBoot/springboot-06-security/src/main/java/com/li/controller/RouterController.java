package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/", "/index"})
    public String index(){
        return "views/index";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "views/login";
    }
    @RequestMapping("leave1/{id}")
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }

    @RequestMapping("leave2/{id}")
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }

    @RequestMapping("leave3/{id}")
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }

}
