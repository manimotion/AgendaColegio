package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Usuario;
import com.agenda_virtual.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AutenticacionControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String mostrarInicioSesion() {
        return "Autenticacion/login";
    }

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@RequestParam("correoElectronico") String correoElectronico,
                                @RequestParam("contrasena") String contrasena,
                                Model model) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(correoElectronico, contrasena));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Aquí puedes agregar la lógica para redirigir a la página principal correspondiente
            // según el rol del usuario (profesor, alumno, padre, administrativo)
            return "redirect:/";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "Correo electrónico o contraseña incorrecta.");
            return "Autenticacion/login";
        }
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "Autenticacion/registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario, Model model) {
        Usuario usuarioExistente = usuarioServicio.findByEmail(usuario.getCorreoElectronico());
        if (usuarioExistente != null) {
            model.addAttribute("error", "El correo electrónico ya está registrado");
            return "Autenticacion/registro";
        }

        Usuario usuarioRegistrado = usuarioServicio.registrarUsuario(usuario);
        if (usuarioRegistrado == null) {
            model.addAttribute("error", "No se pudo registrar al usuario. Intente nuevamente.");
            return "Autenticacion/registro";
        }

        // Redirige al usuario a la página de inicio de sesión
        return "redirect:/login";
    }

    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
