package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("SpringbootApplication Started!");
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		servletContext.addFilter("timeFilter", new TimerFilter())
//		.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "/*");
//	}
}
