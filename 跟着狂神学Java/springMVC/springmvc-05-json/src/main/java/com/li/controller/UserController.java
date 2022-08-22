package com.li.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.li.pojo.User;
import com.li.utils.jsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
public class UserController {
    @RequestMapping("/j1")
    //@ResponseBody //他就不会找视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //jackson ObjectMapper
        ObjectMapper mapper=new ObjectMapper();

        //创建一个对象
        User user = new User("李志炜",3,"男");

        String str = mapper.writeValueAsString(user);

        return str;

    }
    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        //jackson ObjectMapper
        ObjectMapper mapper=new ObjectMapper();

        List<User> userList = new ArrayList<User>();

        User user1 = new User("李志炜1",3,"男");
        User user2 = new User("李志炜2",3,"男");
        User user3 = new User("李志炜3",3,"男");
        User user4 = new User("李志炜4",3,"男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return jsonUtil.getJson(userList);

    }
    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        Date date=new Date();

        return jsonUtil.getJson(date, "yyyy-MM-dd HH:mm:ss");

    }
    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {

        List<User> userList = new ArrayList<User>();

        User user1 = new User("李志炜1",3,"男");
        User user2 = new User("李志炜2",3,"男");
        User user3 = new User("李志炜3",3,"男");
        User user4 = new User("李志炜4",3,"男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

       return JSON.toJSONString(userList);

    }
}
