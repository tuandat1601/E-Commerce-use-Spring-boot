package com.bootcamp.customer.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bootcamp.library.model.Customer;
import com.bootcamp.library.model.ShoppingCart;
import com.bootcamp.library.service.CustomerService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CustomerService customerService;

    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model, Principal principal, HttpSession session) {
        model.addAttribute("title", "Home");
        model.addAttribute("page", "Home");
        model.addAttribute("serverPort", serverPort);
        if (principal != null) {
            Customer customer = customerService.findByUserName(principal.getName());
            session.setAttribute("username", customer.getFirstName() + " " + customer.getLastName());
            ShoppingCart shoppingCart = customer.getCart();
            if (shoppingCart != null) {
                session.setAttribute("totalItems", shoppingCart.getTotalItems());
            }
        }
        return "home";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("page", "Contact");
        return "contact-us";
    }

}
