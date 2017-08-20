package com.my.quickweb;

import java.time.LocalTime;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MyController {
	
	
	@ModelAttribute("env")
	public String getEnv(HttpSession session) {
		String env = (String)session.getAttribute("env");
		if(null==env || env.trim().equals("")) {
			env = "NONE";
		}
		return env;
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "The time is "+LocalTime.now());
		return "homePage.html";
	}
	

	
}
