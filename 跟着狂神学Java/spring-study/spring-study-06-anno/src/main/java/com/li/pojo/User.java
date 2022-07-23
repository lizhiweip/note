package com.li.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//这个注解的意思是这个类被spring接管了，注册到容器中
@Component
public class User {
    @Value("荔枝味")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
