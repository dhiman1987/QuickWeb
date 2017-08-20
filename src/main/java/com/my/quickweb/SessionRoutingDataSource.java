package com.my.quickweb;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("rest/session/")
public class SessionRoutingDataSource extends AbstractRoutingDataSource {



	@GetMapping("set-env/{env}")
	public String setEnv(@PathVariable("env") String env, HttpSession session) {
		env = env.toUpperCase();
		String sessionEnv = (String) session.getAttribute("env");
		session.setAttribute("env",env );
		if(null!=sessionEnv) {
			return "Environment chenged from "+sessionEnv+" to "+env.toUpperCase();
		}
		return "Environment set to "+env;
	}



	public SessionRoutingDataSource() {
		Map<Object,Object> targetDataSources =  new HashMap<>();

		DriverManagerDataSource prodDataSource = new DriverManagerDataSource();
		prodDataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		prodDataSource.setUrl("jdbc:derby://localhost:1527/sample");
		prodDataSource.setUsername("prod");
		prodDataSource.setPassword("123");


		DriverManagerDataSource devDataSource = new DriverManagerDataSource();
		devDataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		devDataSource.setUrl("jdbc:derby://localhost:1527/sample");
		devDataSource.setUsername("dev");
		devDataSource.setPassword("123");

		targetDataSources.put("PROD", prodDataSource);
		targetDataSources.put("DEV", devDataSource);

		this.setTargetDataSources(targetDataSources);

	}

	@Override
	protected Object determineCurrentLookupKey() {
		if(null==RequestContextHolder.getRequestAttributes()){
			return "PROD";
		}
		HttpServletRequest request = ((ServletRequestAttributes)
				RequestContextHolder.getRequestAttributes()).getRequest();

		if(null==request.getSession().getAttribute("env")){
			return "PROD";
		}
		return request.getSession().getAttribute("env");
	}

}