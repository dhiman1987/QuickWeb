package com.my.quickweb;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MyConfig {

	@Autowired
	Map<String,MyDs> dataSources;
	
	@Bean
	public MyDao myDao() {
		//default DB connected
		return new MyDao(this.dataSources.get("myDsProd"));
	}
	
	/*@Bean("DEV")
	public DriverManagerDataSource getDevDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		dataSource.setUrl("jdbc:derby://localhost:1527/sample");
		dataSource.setUsername("dev");
		dataSource.setPassword("123");
		return dataSource;
	}
	
	@Bean("PROD")
	public DriverManagerDataSource getProdDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		dataSource.setUrl("jdbc:derby://localhost:1527/sample");
		dataSource.setUsername("prod");
		dataSource.setPassword("123");
		return dataSource;
	}*/
}
