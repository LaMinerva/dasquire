package com.budgetmanager.budgetmanager_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.budgetmanager.budgetmanager_app.dto.UserDto;
import com.budgetmanager.budgetmanager_app.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registrati")
    public String signupForm(){
        return"pages/registrati";
    }

    //per ricevere dati dal form e reindirizzare l'utente post-registrazione
    //da cambiare con pagina che ti mostra un messaggio nella quale devi confermare l'email
    @PostMapping("/registrati")
    public String doSignup(@ModelAttribute UserDto form){
        userService.reigister(form);
        return "redirect:/accedi";
    }
    
    @GetMapping("/accedi")
    public String loginForm(){
        return"pages/accedi";
    }
    
}
