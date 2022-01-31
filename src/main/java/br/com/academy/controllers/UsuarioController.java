package br.com.academy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.models.Usuario;
import br.com.academy.services.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }
    @PutMapping
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return usuarioService.atualizar(usuario);
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.salvar(usuario);
    }

    @PostMapping("/login")
    public Usuario efetuarlogin(@RequestBody Usuario usuario) {
        return usuarioService.efetuarLogin(usuario);
    }
}
