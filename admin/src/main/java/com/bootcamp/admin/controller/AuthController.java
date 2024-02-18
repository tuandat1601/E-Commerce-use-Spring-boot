package com.bootcamp.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AuthController {
	@RequestMapping("/login")
public String login() {
	return "login";
}
	@RequestMapping("/register")
public String register() {
	return "register";
}

@RequestMapping("/hello")
public String hello(Model model) {
	model.addAttribute("message", "Tuấn Đạt");
	return "fragments";
	
}
}
