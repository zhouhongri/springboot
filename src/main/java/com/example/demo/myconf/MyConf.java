package com.example.demo.myconf;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.controller.ServletTest;

@Configuration
public class MyConf {
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new ServletTest(),"/servletTest");
	}
}
