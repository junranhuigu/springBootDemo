package com.bootStart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("error")
	public String error(){
		return "message/error";
	}
	
	@RequestMapping("model")
	public String model(String name, Model model){
		model.addAttribute("name", name);
		return "show/model";
	}
}
