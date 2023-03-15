package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.modelos.Profesor;
import com.agenda_virtual.modelos.Usuario;

import java.util.HashMap;
import java.util.Map;

public class AutenticacionControlador {

    // Simula una base de datos de usuarios para propósitos de ejemplo
    private Map<String, Usuario> usuarios;

    public AutenticacionControlador() {
        // Inicializar el mapa de usuarios (en lugar de esto, se podría acceder a una base de datos real)
        usuarios = new HashMap<>();

        // Agregar algunos usuarios de ejemplo al mapa (esto debería reemplazarse por una consulta a la base de datos)
        usuarios.put("profesor@example.com", new Profesor(1, "John", "Doe", "profesor@example.com", "profesor123", "Matemáticas"));
        usuarios.put("alumno@example.com", new Alumno(2, "Jane", "Doe", "alumno@example.com", "alumno123", 10,"A"));
    }

    // Método para iniciar sesión
    public Usuario iniciarSesion(String correoElectronico, String contrasena) {
        Usuario usuario = usuarios.get(correoElectronico);

        if (usuario != null && usuario.getContraseña().equals(contrasena)) {
            // Inicio de sesión exitoso
            return usuario;
        } else {
            // Inicio de sesión fallido
            return null;
        }
    }
}

