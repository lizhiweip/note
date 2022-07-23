package com.li.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到session
        HttpSession session=req.getSession();
        //给session中存东西
        session.setAttribute("name","荔枝味");
        //获取session的ID
        String id=session.getId();
        //判断session是不是新创建
        if(session.isNew()){
            resp.getWriter().write("创建成功,ID:"+id);
        }else{
            resp.getWriter().write("session在服务器中已经存在了，ID"+id);
        }
        //session在创建的时候做了什么事情
        //Cookie cookie=new Cookie("JSESSIONID",sessionid);
        //resp.addCookie(cookie)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
