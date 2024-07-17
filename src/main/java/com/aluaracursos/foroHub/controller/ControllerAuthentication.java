package com.aluaracursos.foroHub.controller;

import com.aluaracursos.foroHub.DTO.DatosDTOUsuario;
import com.aluaracursos.foroHub.modelo.usuario.DatosToken;
import com.aluaracursos.foroHub.service.ServiceToken;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class ControllerAuthentication {
    @Autowired
    private ServiceToken service;
    @Autowired
    private AuthenticationManager manager;


    @PostMapping
    public ResponseEntity<DatosToken> autenticarUsuario(@RequestBody @Valid Login usuario) throws NoExiste, ProblemasGenerarToken {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuario.email(),
                usuario.contrasena());
        var usuarioAutenticado = manager.authenticate(authToken);
        var JWTtoken = service.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosToken(JWTtoken));
    }

    @PostMapping("/registrar")
    public ResponseEntity<DatosDTOUsuario> registrarUsuario(@RequestBody @Valid DatosUsuario usuario) throws NoExiste, ProblemasGenerarToken {
        var nuevoUsuario = service.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
