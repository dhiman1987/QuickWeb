package com.my.quickweb;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/")
public class MyRestEndpoint {
	
	@GetMapping("ping")
	public String getServerTime() {
		
		return "Server Time : "+LocalTime.now();
	}
	
	@GetMapping("greeting")
	public Greeting getGreeting() {
		
		return new Greeting("Hello world!!!", LocalTime.now());
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
