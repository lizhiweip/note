package com.li.util;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码问题
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";

        Connection connection=null;
        //1,加载驱动
        try{
        Class.forName("com.mysql.jdbc.Driver");
        //2，连接数据库
            connection = DriverManager.getConnection(url, username, password);

        //通知数据库开启事务false是开启
        connection.setAutoCommit(false);
        String sql="update account set money =money-100 where name='A'";
        connection.prepareStatement(sql).executeUpdate();

        //制造错误
        int i=1/0;
        String sql2="update account set money=money+100 where name='B'";
        connection.prepareStatement(sql).executeUpdate();

        connection.commit();//以上两条SQL都执行成功了，就提交事务！
        System.out.println("success");
        }catch (ClassNotFoundException e){
            try{
                //如果异常，就通知数据库滚回事务
                connection.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}
