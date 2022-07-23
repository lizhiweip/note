package com.li.config;

import com.li.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    //这个注解的意思是这个类被spring接管了，注册到容器中，因为它本来就是一个@Component,
    // @Configuration代表这是一个配置类，和bean.xml一样
    //注册一个bean就相当于我们之前写的一个bean标签，这个方法的名字就相当于bean标签中的class值
    @Bean
    public User getUser(){
        return new User();
    }
}
