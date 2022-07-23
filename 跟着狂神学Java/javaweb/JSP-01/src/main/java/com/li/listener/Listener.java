package com.li.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener {
    @Override
    //创建session监听
    //一旦创建session就会触发这个事件
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx=se.getSession().getServletContext();
        Integer onlineCount=(Integer) ctx.getAttribute("onlineCount");

        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else{
            int count =onlineCount.intValue();

            onlineCount=new Integer(count+1);
            
        }
    }

    @Override
    //销毁session监听
    //一旦销毁session就会触发这个事件
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx=se.getSession().getServletContext();
        Integer onlineCount=(Integer) ctx.getAttribute("onlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(0);
        }else{
            int count =onlineCount.intValue();

            onlineCount=new Integer(count-1);

        }
        /*
        Session的销毁
        1，手动销毁 getSession().invalidate();
        2，自动销毁
         */
    }
}
