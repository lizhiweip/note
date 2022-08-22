package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultSpringMVC {
    //不需要视图解析器，也不能有，否则路径会拼接成畸形
    @RequestMapping("/rsm/t1")
    public String test1(){
        //转发
        return "/WEN-INF/jsp/index.jsp";
    }

    @RequestMapping("/rsm/t2")
    public String test2(){
        //转发2
        return "forward:/index.jsp";
    }

    @RequestMapping("/rsm/t3")
    public String test3(){
        //重定向
        return "redirect:/index.jsp";
    }
}
