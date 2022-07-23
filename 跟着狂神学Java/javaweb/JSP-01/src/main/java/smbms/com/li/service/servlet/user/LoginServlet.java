package smbms.com.li.service.servlet.user;

import smbms.com.li.pojo.User;
import smbms.com.li.service.user.UserService;
import smbms.com.li.service.user.UserServiceImpl;
import smbms.com.li.service.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //Servlet：控制层调用业务层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start....");
        //获取用户名和密码
        String username =req.getParameter("username");
        String userpassword=req.getParameter("userpassword");
        //和数据库中的密码进行比较，调用业务层
        UserService userService=new UserServiceImpl();
        User user=userService.login(username,userpassword);//这里已经把登录的人查出来了
        if(user!=null){
            //将用户的信息放到Session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else{
            //查无此人，无法登陆
            //转发回登录页面，顺带提示它，用户或者密码错误
            req.setAttribute("error","用户名或密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
