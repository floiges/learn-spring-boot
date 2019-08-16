package com.example.springboothello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller 中的方法以 json 格式输出
public class HelloWorldController {
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
}
