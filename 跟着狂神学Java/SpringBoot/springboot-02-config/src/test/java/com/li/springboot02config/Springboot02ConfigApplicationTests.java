package com.li.springboot02config;

import com.li.pojo.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {
@Autowired
	private Dog dog;
	@Test
	void contextLoads() {
		System.out.println(dog);
	}

}
