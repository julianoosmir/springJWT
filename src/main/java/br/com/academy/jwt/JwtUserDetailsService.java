package br.com.academy.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.academy.models.Usuario;
import br.com.academy.services.UsuarioService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarPorUsername(username);

        if (usuario.getUsername().equals(username)) {
            return new User(username, usuario.getSenha(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
    }
}