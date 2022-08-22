package com.li.helloSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//程序主入口Z导入
@SpringBootApplication
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		//将springboot应用启动
		//SpringApplication类
		//run方法，开启了一个服务，两个参数；应用入口的类 命令行参数
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

}
