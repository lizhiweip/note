package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
   shiro三大对象
   Subject 用户
   SecurityManager 管理所有用户
   Real  连接数据
 */

@SpringBootApplication
public class ShiroSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroSpringbootApplication.class, args);
	}

}
