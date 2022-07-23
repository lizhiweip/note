package com.li.dao;

import com.li.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //模糊查询
    List<User> getUserLike(String value);

    //获取全部用户
    List<User>getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //万能的MAP
    User addUser2(Map<String,Object> map);

    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User User);

    //删除一个用户
    int deleteUser(int id);

    //分页查询
    List<User> getUserByLimit(Map<String,Integer> map);

    //通过RowBound分页
    List<User> getUserByRowBounds();
}
