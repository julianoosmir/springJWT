package br.com.academy.jwt;

import java.io.Serializable;

import br.com.academy.models.Usuario;
import lombok.Getter;

@Getter
public class JwtResponse implements Serializable {

    private String token;
    private String username;
    private String nome;
    private String email;

    public JwtResponse(Usuario usuario, String token) {
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.token = "Bearer " + token;
    }

    public JwtResponse(Usuario usuario) {
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
    }
}