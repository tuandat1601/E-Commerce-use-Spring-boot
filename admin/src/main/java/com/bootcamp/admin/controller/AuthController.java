package com.bootcamp.admin.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.library.dto.AdminDto;
import com.bootcamp.library.model.Admin;
import com.bootcamp.library.service.AdminService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {
	
	  private final AdminService adminService;

	    private final BCryptPasswordEncoder passwordEncoder;
	    @RequestMapping("/index")
	    public String index(Model model) {
	        model.addAttribute("title", "Home Page");
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        
	        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
	        	System.out.println(authentication);
	        	return "redirect:/login";
	        }
	        return "index";
	    }
	  @RequestMapping("/login")
	    public String login(Model model) {
	        model.addAttribute("title", "Login Page");
	        return "login";
	    }
	  @GetMapping("/register")
	    public String register(Model model) {
	        model.addAttribute("title", "Register");
	        model.addAttribute("adminDto", new AdminDto());
	        return "register";
	    }
	  @PostMapping("/register-new")
	    public String addNewAdmin(@Valid @ModelAttribute("adminDto") AdminDto adminDto,
	                              BindingResult result,
	                              Model model) {

	        try {
	            if (result.hasErrors()) {
	            	System.out.println(result);
	                model.addAttribute("adminDto", adminDto);
	                return "register";
	            }
	            String username = adminDto.getUserName();
	            Admin admin = adminService.findByUserName(username);
	            if (admin != null) {
	                model.addAttribute("adminDto", adminDto);
	                System.out.println("admin not null");
	                model.addAttribute("emailError", "Your email has been registered!");
	                return "register";
	            }
	            if (adminDto.getPassword().equals(adminDto.getRepeatPassword())) {
	                adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
	                adminService.save(adminDto);
	                System.out.println("success");
	                model.addAttribute("success", "Register successfully!");
	                model.addAttribute("adminDto", adminDto);
	                return "register";
	            } else {
	                model.addAttribute("adminDto", adminDto);
	                model.addAttribute("passwordError", "Your password maybe wrong! Check again!");
	                System.out.println("password not same");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            model.addAttribute("errors", "The server has been wrong!");
	        }
	        return "register";

	    }
	  @GetMapping("/forgot-password")
	    public String forgotPassword(Model model) {
	        model.addAttribute("title", "Forgot Password");
	        return "forgot-password";
	    }
@RequestMapping("/hello")
public String hello(Model model) {
	model.addAttribute("message", "Tuấn Đạt");
	return "fragments";
	
}
}
