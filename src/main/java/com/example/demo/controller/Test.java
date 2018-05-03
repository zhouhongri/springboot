package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/freemarkerCtrl")
public class Test {
	
	@RequestMapping("/")
	@ResponseBody
	public String haha() {
		return "66666";
	}
	@RequestMapping("/hello")
	public String haha2(Map<String,Object> map) {
		map.put("msg", "hello thymeleaf");
		return "view-hello";
	}
}
