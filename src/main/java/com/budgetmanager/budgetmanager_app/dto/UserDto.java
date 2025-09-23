package com.budgetmanager.budgetmanager_app.dto;

public class UserDto {
    private String nome;
    private String cognome;
    private String alias;
    private String dataNascita;
    private String codiceFiscale;
    private String email;
    private String password;

    public String getNome(){return nome;}
    public void setNome(String x){this.nome = x;}
    public String getCognome(){return cognome;}
    public void setCognome(String x){this.cognome = x;}
    public String getAlias(){return alias;}
    public void setAlias(String x){this.alias = x;}
    public String getDataNascita(){return dataNascita;}
    public void setDataNascita(String x){this.dataNascita = x;}
    public String getCodiceFiscale(){return codiceFiscale;}
    public void setCodiceFiscale(String x){this.codiceFiscale = x;}
    public String getEmail(){return email;}
    public void setEmail(String x){this.email = x;}
    public String getPassword(){return password;}
    public void setPassword(String x){this.password = x;}
}
