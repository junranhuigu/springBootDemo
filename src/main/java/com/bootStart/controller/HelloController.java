package com.bootStart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	@RequestMapping("say")
	public String say(){
		return "Hello World!";
	}
	
	@RequestMapping("what")
	public String sayWhat(String what){
		return "Hello " + what;
	}
}
