package com.my.quickweb;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MyController {
	
	@Autowired
	private MyDao myDao;
	
	@ModelAttribute("env")
	public String getEnv() {
		return this.myDao.getDbName();
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "The time is "+LocalTime.now());
		return "homePage.html";
	}
	
}
