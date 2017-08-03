package com.my.quickweb;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
	private MovieRepository movieRepository;
	
	@GetMapping("ping")
	public String getServerTime() {
		
		return "Server Time : "+LocalTime.now();
	}
	
	@GetMapping("greeting")
	public Greeting getGreeting() {
		
		return new Greeting("Hello world!!!", LocalTime.now());
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		movieRepository.findAll().forEach(movies::add);
		return movies;
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
