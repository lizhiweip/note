package com.li.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

//中文数据传递
public class Servlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        Cookie[] cookies=req.getCookies();//这里说明Cookie可能存在多个
        if(cookies!=null){
            //如果存在怎么办
            out.write("你上次访问的时间是");
            for (int i=0;i<cookies.length;i++) {
                Cookie cookie=cookies[i];
                //获取cookie的名字
                if(cookie.getName().equals("name")){
                    //解码
                    out.write(URLDecoder.decode(cookie.getValue(),"utf-8"));

                }
            }
        }else{
            out.write("这是第一次访问本站");
        }
        //编码
        Cookie cookie=new Cookie("name", URLEncoder.encode("荔枝味","utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
