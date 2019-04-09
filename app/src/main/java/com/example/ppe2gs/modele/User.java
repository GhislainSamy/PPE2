package com.example.ppe2gs.modele;

public class User {

    private String id;
    private String username;
    private String roles;
    private String password;
    private Object telephone;
    private Object email;
    private Object adresse;
    private Object ville;
    private Object cp;
    private Object dateajout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getTelephone() {
        return telephone;
    }

    public void setTelephone(Object telephone) {
        this.telephone = telephone;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getAdresse() {
        return adresse;
    }

    public void setAdresse(Object adresse) {
        this.adresse = adresse;
    }

    public Object getVille() {
        return ville;
    }

    public void setVille(Object ville) {
        this.ville = ville;
    }

    public Object getCp() {
        return cp;
    }

    public void setCp(Object cp) {
        this.cp = cp;
    }

    public Object getDateajout() {
        return dateajout;
    }

    public void setDateajout(Object dateajout) {
        this.dateajout = dateajout;
    }
}
