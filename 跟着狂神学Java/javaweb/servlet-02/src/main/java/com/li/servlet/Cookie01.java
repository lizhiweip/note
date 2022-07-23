package com.li.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class Cookie01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器告诉你你来的时间，把这个时间封装成为一个信件，你下次带来，我就知道你来了
        //解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        //Cookie,服务端从客户端获取
        javax.servlet.http.Cookie[] cookies=req.getCookies();//这里说明Cookie可能存在多个
        //判断Cookies是否存在
        if(cookies!=null){
            //如果存在怎么办
            out.write("你上次访问的时间是");
            for (int i=0;i<cookies.length;i++) {
                Cookie cookie=cookies[i];
                //获取cookie的名字
                if(cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值
                    Long lastLoginTime=Long.parseLong(cookie.getValue());
                    Date date=new Date(lastLoginTime);
                    out.write(date.toLocaleString()); 
                }
            }
        }else{
            out.write("这是第一次访问本站");
        }
        //服务器给客户端响应一个cookie；
        Cookie cookie=new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
