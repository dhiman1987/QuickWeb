package com.my.quickweb;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Autowired
	Map<String,MyDs> dataSources;
	
	@Bean
	public MyDao myDao() {
		//default DB connected
		return new MyDao(this.dataSources.get("myDsProd"));
	}
}
