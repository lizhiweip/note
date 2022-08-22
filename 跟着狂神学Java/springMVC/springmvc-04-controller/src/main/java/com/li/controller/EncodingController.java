package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {
   //过滤器解决乱码 直接在web.xml中配
@RequestMapping("/e/t2")
    public String test1(String name, Model model){
    model.addAttribute("msg",name);
    return "test";
    }

}
