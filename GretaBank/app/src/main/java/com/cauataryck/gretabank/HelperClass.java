package com.cauataryck.gretabank;

public class HelperClass {

    String name, email, user, senha;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public HelperClass(String name, String email, String user, String senha) {
        this.name = name;
        this.email = email;
        this.user = user;
        this.senha = senha;
    }

    public HelperClass() {
    }
}
