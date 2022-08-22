package com.li;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

	/**
	 *
	 */
	@Autowired(required = false)
	DataSource dataSource;

	@Test
	void contextLoads() {
		//查看默认数据源 com.zaxxer.hikari.HikariDataSource
		System.out.println(dataSource.getClass());

		//获得数据库连接
		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);

			//xxxTemplate:springBoot已经配置好的模板bean，拿来即用 CRUD

			//关闭
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
