package smbms.com.li.service.user;

import smbms.com.li.pojo.User;

public interface UserService {
    //用户登录
    public User login (String userCode, String password);
}
