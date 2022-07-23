package com.li.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1,获取下载文件的路径
        String realPath=this.getServletContext().getRealPath("E:\\跟着狂神学Java\\javaweb\\servlet-02\\src\\main\\resources\\1.jpg");
        System.out.println("下载的文件路径："+realPath);
        //2,下载的文件名是啥
        String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
        //3，设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);
        //4，获取下载文件的输入流
        FileInputStream in=new FileInputStream(realPath);
        //5，创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
        //6，获取OutputStream对象
        ServletOutputStream out=resp.getOutputStream();
        //7，将FileOutputstream流写入到buffer缓冲区
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
        //8，用OutputStream将缓冲区的数据输出到客户端
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
