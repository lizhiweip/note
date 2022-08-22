package com.li;

import com.li.mapper.UserMapper;
import com.li.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/QueryUserById/{id}")
    public User QueryUserById(@PathVariable("id") int id){
        User user = userMapper.QueryUserById(id);
        System.out.println(user);
        return user;
    }

    @GetMapping("/addUser")
    public int addUser(){
        userMapper.addUser(new User(6,"李","123"));
        return 1;
    }

    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
        return 1;
    }

    @GetMapping("/updateUser")
    public int updateUser(){
        User user=new User(5,"荔枝味","111");
        userMapper.updateUser(user);
        return 1;
    }

}
