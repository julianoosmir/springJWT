package br.com.academy.jwt;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.models.Usuario;
import br.com.academy.services.UsuarioService;



@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/autenticar", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        Usuario input = new Usuario();

        input.setUsername(authenticationRequest.getUsername());
        input.setSenha(authenticationRequest.getSenha());

        final Usuario usuario = usuarioService.efetuarLogin(input);

        if (Objects.nonNull(usuario))
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getSenha());

        final String token = jwtTokenUtil.generateToken(usuario);
        return ResponseEntity.ok(new JwtResponse(usuario, token));
    }

    @GetMapping(path = "/verifica")
    public ResponseEntity<?> verificaToken() {
        Usuario usuario = usuarioService.buscarPorUsername(UsuarioService.authenticated().getUsername());
        return ResponseEntity.ok(new JwtResponse(usuario));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}