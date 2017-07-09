package com.my.quickweb;

import org.springframework.stereotype.Component;

@Component
public class MyDsDev implements MyDs{

	@Override
	public String getName() {
		return "DEV DATASOURCE.";
	}

}
