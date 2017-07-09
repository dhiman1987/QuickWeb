package com.my.quickweb;

import org.springframework.stereotype.Component;

@Component
public class MyDsProd implements MyDs{

	@Override
	public String getName() {
		return "PROD DATASOURCE.";
	}

}
