package smbms.com.li.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImp implements UserDao{
    @Override
    public User getLoginUser(Connection connection, String userCode) {
        PreparedStatement pst =null;
        ResultSet rs=null;
        User user=null;

       String sql ="select * from smbms_user where userCode";
       Object[] params ={userCode};

     return user;
    }
}
