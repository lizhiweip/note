package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/goLogin")
    public String login(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, String userName, String password, Model model){
        //把用户信息存在session中
        session.setAttribute("userLoginInfo",userName);
        model.addAttribute("username",userName);
        return "main";
    }
    @RequestMapping("/goOut")
    public String goOut(HttpSession session, String userName, String password, Model model){
        //把用户信息存在session中
        session.invalidate();
        session.removeAttribute("userLoginInfo");
        return "main";
    }
}
