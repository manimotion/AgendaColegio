package com.agenda_virtual.controladores.api;

import com.agenda_virtual.modelos.Usuario;
import com.agenda_virtual.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionApiController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestBody Usuario usuario) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usuario.getCorreoElectronico(),
                            usuario.getContraseña()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            Usuario usuarioAutenticado = usuarioServicio.findByEmail(usuario.getCorreoElectronico());

            if (usuarioAutenticado != null) {
                return ResponseEntity.ok(usuarioAutenticado);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> cerrarSesion() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return ResponseEntity.ok("Sesión cerrada con éxito");
    }
}
