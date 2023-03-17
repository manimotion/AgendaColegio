package com.agenda_virtual.controladores.api;

import com.agenda_virtual.modelos.Rol;
import com.agenda_virtual.modelos.Usuario;
import com.agenda_virtual.repositorios.RolRepositorio;
import com.agenda_virtual.servicios.RolServicio;
import com.agenda_virtual.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioApiController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private RolServicio rolServicio;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        // Aquí puedes agregar validaciones adicionales antes de guardar el usuario.

        // Verificar si el correo electrónico ya está registrado
        Usuario usuarioExistente = usuarioServicio.findByEmail(usuario.getCorreoElectronico());
        if (usuarioExistente != null) {
            return new ResponseEntity<>("El correo electrónico ya está registrado", HttpStatus.BAD_REQUEST);
        }

        // Verificar que el usuario tenga al menos un rol
        Set<Rol> roles = usuario.getRoles();
        if (roles == null || roles.isEmpty()) {
            return new ResponseEntity<>("Debe asignar al menos un rol al usuario", HttpStatus.BAD_REQUEST);
        }

        // Buscar los roles existentes en la base de datos y asignarlos al usuario
        Set<Rol> rolesEncontrados = new HashSet<>();
        for (Rol rol : roles) {
            Rol rolEncontrado = rolServicio.obtenerRolPorNombre(rol.getNombre());
            if (rolEncontrado != null) {
                rolesEncontrados.add(rolEncontrado);
            } else {
                return new ResponseEntity<>("Rol no encontrado: " + rol.getNombre(), HttpStatus.BAD_REQUEST);
            }
        }
        usuario.setRoles(rolesEncontrados);

        // Cifrar la contraseña antes de guardar el usuario
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));

        // Guardar el usuario con los roles asignados y la contraseña cifrada
        Usuario usuarioRegistrado = usuarioServicio.guardarUsuario(usuario);

        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuarioServicio.buscarUsuarioPorId(id);

        if (usuario.isPresent()) {
            usuarioServicio.eliminarUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Optional<Usuario> usuarioOptional = usuarioServicio.buscarUsuarioPorId(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setRoles(usuarioActualizado.getRoles());
            usuarioServicio.guardarUsuario(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioServicio.obtenerTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}
