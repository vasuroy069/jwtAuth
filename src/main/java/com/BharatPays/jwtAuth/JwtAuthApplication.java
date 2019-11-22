package com.BharatPays.jwtAuth;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class JwtAuthApplication {

    @Autowired
    private Environment env;
    
	public static void main(String[] args) {
		SpringApplication.run(JwtAuthApplication.class, args);
	}
	
	/*
	 * @Bean public DataSource getDataSource() { BasicDataSource dataSource = new
	 * BasicDataSource();
	 * dataSource.setDriverClassName(env.getProperty("mysql.driver"));
	 * dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
	 * dataSource.setUsername(env.getProperty("mysql.username"));
	 * dataSource.setPassword(env.getProperty("mysql.password")); return dataSource;
	 * }
	 */

}
