package com.bootcamp.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.library.dto.AdminDto;

@Controller

public class AuthController {
	@RequestMapping("/login")
public String login() {
	return "login";
}
	  @GetMapping("/register")
	    public String register(Model model) {
	        model.addAttribute("title", "Register");
	        model.addAttribute("adminDto", new AdminDto());
	        return "register";
	    }

@RequestMapping("/hello")
public String hello(Model model) {
	model.addAttribute("message", "Tuấn Đạt");
	return "fragments";
	
}
}
