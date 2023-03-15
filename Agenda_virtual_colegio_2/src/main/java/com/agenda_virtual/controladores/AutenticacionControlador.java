package com.agenda_virtual.controladores;


import com.agenda_virtual.modelos.Usuario;
import com.agenda_virtual.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutenticacionControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/iniciarSesion")
    public String mostrarInicioSesion() {
        return "inicioSesion";
    }

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@RequestParam("correoElectronico") String correoElectronico,
                                @RequestParam("contrasena") String contrasena,
                                Model model) {
        Usuario usuario = usuarioServicio.autenticarUsuario(correoElectronico, contrasena);
        if (usuario == null) {
            model.addAttribute("error", "Correo electrónico o contraseña incorrecta.");
            return "inicioSesion";
        }

        // Aquí puedes agregar la lógica para redirigir a la página principal correspondiente
        // según el rol del usuario (profesor, alumno, padre, administrativo)
        return "redirect:/";
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario, Model model) {
        Usuario usuarioRegistrado = usuarioServicio.registrarUsuario(usuario);
        if (usuarioRegistrado == null) {
            model.addAttribute("error", "No se pudo registrar al usuario. Intente nuevamente.");
            return "registro";
        }

        // Aquí puedes agregar la lógica para redirigir a la página principal correspondiente
        // según el rol del usuario (profesor, alumno, padre, administrativo)
        return "redirect:/";
    }
}
