package com.example.demo.controller;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/admin")
    public String showTeacherPage(Model model) {
        model.addAttribute("users", customerService.getCustomers());
        return "admin";
    }

    @RequestMapping("/customer")
    public String showStudentPage(Authentication authentication, Model model) {
        String usernameLogined  = authentication.getName();
        CustomerEntity user = customerService.getCustomerByUsername(usernameLogined);
        model.addAttribute("user", user);
        return "customer";
    }
}
