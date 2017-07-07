package com.my.quickweb;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "The time is "+LocalTime.now());
		return "homePage.html";
	}
}
