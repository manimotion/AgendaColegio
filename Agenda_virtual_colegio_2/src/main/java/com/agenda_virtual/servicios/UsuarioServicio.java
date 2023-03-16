package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.modelos.Padre;
import com.agenda_virtual.modelos.Usuario;
import com.agenda_virtual.repositorios.AlumnoRepositorio;
import com.agenda_virtual.repositorios.PadreRepositorio;
import com.agenda_virtual.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    @Autowired
    private PadreRepositorio padreRepositorio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Alumno guardarAlumno(Alumno alumno) {
        alumno.setContraseña(bCryptPasswordEncoder.encode(alumno.getContraseña()));
        return alumnoRepositorio.save(alumno);
    }

    public Padre guardarPadre(Padre padre) {
        return padreRepositorio.save(padre);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Alumno obtenerAlumnoPorId(Long id) {
        return alumnoRepositorio.findById(id).orElse(null);
    }

    public Padre obtenerPadrePorId(Long id) {
        return padreRepositorio.findById(id).orElse(null);
    }

    public List<Alumno> listarAlumnos() {
        return alumnoRepositorio.findAll();
    }

    public List<Padre> listarPadres() {
        return padreRepositorio.findAll();
    }

    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    public void eliminarAlumno(Long id) {
        alumnoRepositorio.deleteById(id);
    }

    public void eliminarPadre(Long id) {
        padreRepositorio.deleteById(id);
    }

    public Alumno obtenerAlumnoPorCorreoElectronico(String correoElectronico) {
        return alumnoRepositorio.findByCorreoElectronico(correoElectronico);
    }

    // Puedes agregar más métodos según las necesidades de tu aplicación
    public Usuario autenticarUsuario(String correoElectronico, String contrasena) {
        Usuario usuario = usuarioRepositorio.findByCorreoElectronico(correoElectronico);
        if (usuario != null && usuario.getContraseña().equals(contrasena)) {
            return usuario;
        } else {
            return null;
        }
    }

    public Usuario registrarUsuario(Usuario usuario) {
        // Aquí puedes agregar cualquier validación adicional o lógica de negocio antes de guardar el usuario.
        return usuarioRepositorio.save(usuario);
    }

    public Usuario findByEmail(String correoElectronico) {
        return usuarioRepositorio.findByCorreoElectronico(correoElectronico);
    }
}
