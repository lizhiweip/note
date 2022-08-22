package com.li.controller;

import com.li.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>"+name);
        if("lizhiwei".equals(name)){
            response.getWriter().println("true");
        }else{
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> list=new ArrayList<User>();
        //添加数据
        list.add(new User("后端荔枝味",19,"男"));
        list.add(new User("前端荔枝味",19,"女"));
        return list;
    }
    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg="";
        if(name!=null){
            //admin这些数据应该在数据库中查
            if("admin".equals(name)){
                msg="ok";
            }else{
                msg="用户名有误";
            }
        }
        if(name!=null){
            //admin这些数据应该在数据库中查
            if("12345".equals(name)){
                msg="ok";
            }else{
                msg="密码有误";
            }
        }
        return msg;
    }

}
