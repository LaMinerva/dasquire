package com.budgetmanager.budgetmanager_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.budgetmanager.budgetmanager_app.repository.UserRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/chi-siamo")
    public String chiSiamo(){
        return "pages/extra/chi-siamo";
    }

    @GetMapping("/contatti")
    public String contatti(){
        return "pages/extra/contatti";
    }

    @GetMapping("/altri-progetti")
    public String altriProgetti(){
        return "pages/extra/altri-progetti";
    }

    @GetMapping("/dashboard")
    public String dashboard(org.springframework.ui.Model model, org.springframework.security.core.Authentication auth){
        return userRepository.findByEmail(auth.getName())
        .map( u -> {model.addAttribute("user", u); return "pages/dashboard";})
        .orElse("redirect:/accedi?error");
    }
}
