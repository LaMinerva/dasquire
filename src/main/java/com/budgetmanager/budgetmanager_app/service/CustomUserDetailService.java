package com.budgetmanager.budgetmanager_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.budgetmanager.budgetmanager_app.model.User;
import com.budgetmanager.budgetmanager_app.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException{
        User user;
        if(input.contains("@")){
            user = userRepository.findByEmail(input)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + input));
        } else {
            user = userRepository.findByAliasNickname(input)
                .orElseThrow(() -> new UsernameNotFoundException("Alias not found"));
        }

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPasswordHash())
            .authorities("USER")
            .build();
    }
}
