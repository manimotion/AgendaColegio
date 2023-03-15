package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Usuario;
import com.agenda_virtual.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario autenticarUsuario(String correoElectronico, String contrasena) {
        Optional<Usuario> usuario = usuarioRepositorio.findByCorreoElectronico(correoElectronico);
        if (usuario.isPresent() && passwordEncoder.matches(contrasena, usuario.get().getContraseña())) {
            return usuario.get();
        }
        return null;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepositorio.save(usuario);
    }
}