package br.com.academy.jwt;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private String username;
    private String senha;

    public JwtRequest() {
    }

    public JwtRequest(String username, String senha) {
        this.setUsername(username);
        this.setSenha(senha);
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JwtRequest username(String username) {
        setUsername(username);
        return this;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public JwtRequest senha(String senha) {
        setSenha(senha);
        return this;
    }

}