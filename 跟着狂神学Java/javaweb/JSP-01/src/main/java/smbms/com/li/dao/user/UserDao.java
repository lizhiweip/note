package smbms.com.li.dao.user;

import java.sql.Connection;

public interface UserDao {
    //得到要登陆的用户
    public User getLoginUser(Connection connection,String userCode);

}
