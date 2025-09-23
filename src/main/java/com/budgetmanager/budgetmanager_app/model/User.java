package com.budgetmanager.budgetmanager_app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cognome;

    @Column(name="alias_nickname", nullable = true, length = 50)
    private String aliasNickname;

    @Column(nullable = false)
    private LocalDate dataNascita;

    @Column(name="codice_fiscale", nullable=false, unique = true, length = 16)
    private String codiceFiscale;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(name="password_hash", nullable = false, length = 60)
    private String passwordHash;


    public User(){} //JPA richiede un costruttore vuoto


    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}

    public String getCognome(){return cognome;}
    public void setCognome(String cognome){this.cognome = cognome;}
    
    public String getAliasNickname(){return aliasNickname;}
    public void setAliasNickname(String aliasNickname){this.aliasNickname = aliasNickname;}

    public LocalDate getDataNascita(){return dataNascita;}
    public void setDataNascita(LocalDate dataNascita){this.dataNascita = dataNascita;}

    public String getCodiceFiscale(){return codiceFiscale;}
    public void setCodiceFiscale(String codiceFiscale){this.codiceFiscale = codiceFiscale;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPasswordHash(){return passwordHash;}
    public void setPasswordHash(String passwordHash){this.passwordHash = passwordHash;}
    
}
