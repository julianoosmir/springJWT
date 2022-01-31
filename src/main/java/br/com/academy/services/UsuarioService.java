package br.com.academy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import br.com.academy.exceptions.CriptoExistExeption;
import br.com.academy.exceptions.LoginInvalidoException;
import br.com.academy.models.Usuario;
import br.com.academy.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder cript;

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Usuario usuario) {
        Optional<Usuario> UsuarioDB = usuarioRepository.findById(usuario.getId());
        UsuarioDB.ifPresent(u -> usuario.setId(u.getId()));
        return usuarioRepository.save(usuario);
    }

    public Usuario salvar(Usuario usuario) throws Exception {
        try {

            validarSeUsernameExiste(usuario);
            validarSeEmailExiste(usuario);

            usuario.setSenha(cript.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new CriptoExistExeption("de ruim na cripto" + e.getMessage());
        }

    }

    private void validarSeEmailExiste(Usuario usuario) {
        Optional<Usuario> usuarioBD = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioBD.isPresent() && usuario.getId() != usuarioBD.get().getId()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
    }

    private void validarSeUsernameExiste(Usuario usuario) {
        Optional<Usuario> usuarioBD = usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioBD.isPresent() && usuario.getId() != usuarioBD.get().getId()) {
            throw new RuntimeException("Username já cadastrado!");
        }
    }

    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new LoginInvalidoException("Usuário não encontrado"));
    }

    public Usuario efetuarLogin(Usuario input) {

        Usuario usuarioBD = usuarioRepository.findByUsername(input.getUsername()).get();

        Boolean isMatch = cript.matches(input.getSenha(), usuarioBD.getSenha());

        if (!isMatch)
            throw new LoginInvalidoException("Usuário ou senha inválido!");

        return usuarioBD;
    }

    public static UserDetails authenticated() {
        try {
            UserDetails usu = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return usu;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            return null;
        }
    }

}
