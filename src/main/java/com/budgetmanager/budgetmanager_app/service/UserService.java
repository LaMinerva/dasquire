package com.budgetmanager.budgetmanager_app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.budgetmanager.budgetmanager_app.dto.UserDto;
import com.budgetmanager.budgetmanager_app.model.User;
import com.budgetmanager.budgetmanager_app.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired private UserRepository repo;
    @Autowired private PasswordEncoder encoder;

    public void reigister(UserDto d){
        if(repo.existsByEmail(d.getEmail()))
            throw new IllegalArgumentException("Email già registrata");
        if(repo.existsByCodiceFiscale(d.getCodiceFiscale()))
            throw new IllegalArgumentException("Codice fiscale già registrato");
        if(d.getAlias() != null && !d.getAlias().isBlank() && repo.existsByAliasNickname(d.getAlias()))
            throw new IllegalArgumentException("Alias già in uso");

    User u = new User();

    u.setNome(d.getNome());
    u.setCognome(d.getCognome());
    u.setAliasNickname((d.getAlias()==null || d.getAlias().isBlank()) ? null : d.getAlias());
    u.setDataNascita(LocalDate.parse(d.getDataNascita()));
    u.setCodiceFiscale(d.getCodiceFiscale());
    u.setEmail(d.getEmail());
    u.setPasswordHash(encoder.encode(d.getPassword()));

    repo.save(u);
    }
}
