package com.my.quickweb;

import java.time.LocalTime;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/")
public class MyRestEndpoint {
	
	@Autowired
	private Map<String,MyDs> dataSources;
	
	@Autowired
	private MyDao myDao;
	
	@GetMapping("ping")
	public String getServerTime() {
		
		return "Server Time : "+LocalTime.now();
	}
	
	@GetMapping("greeting")
	public Greeting getGreeting() {
		
		return new Greeting("Hello world!!!", LocalTime.now());
	}
	
	@GetMapping("set-env/{env}")
	public String setEnv(@PathVariable("env") String env, HttpSession session) {
		env = env.toUpperCase();
		String sessionEnv = (String) session.getAttribute("env");
		session.setAttribute("env",env );
		
		switch (env) {
		case "DEV": this.myDao.setDataSource(this.dataSources.get("myDsDev"));
		break;
		case "PROD": this.myDao.setDataSource(this.dataSources.get("myDsProd"));
		break;
		default: this.myDao.setDataSource(this.dataSources.get("myDsProd"));
		env ="PROD";
		break;
		}
		
		if(null!=sessionEnv) {
			return "Environment chenged from "+sessionEnv+" to "+env.toUpperCase();
		}
		return "Environment set to "+env;
	}

	static class Greeting{
		private String message;
		private LocalTime time;
		
		public Greeting(String message, LocalTime time) {
			super();
			this.message = message;
			this.time = time;
		}
		public String getMessage() {
			return message;
		}
		public LocalTime getTime() {
			return time;
		}
		
		
	}
}
