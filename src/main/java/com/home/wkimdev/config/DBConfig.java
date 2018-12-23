package com.home.wkimdev.config;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DBConfig {
	
	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springBoard?useSSL=false&amp;serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		
		dataSource.setMaxPoolSize(200);
		dataSource.setCheckoutTimeout(60000);
		dataSource.setMaxIdleTime(1800);
		dataSource.setIdleConnectionTestPeriod(600);
		
		return dataSource;

	}

}
