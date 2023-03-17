package com.agenda_virtual;

import com.agenda_virtual.modelos.Rol;
import com.agenda_virtual.repositorios.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InicializadorRoles implements CommandLineRunner {

    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public void run(String... args) {
        List<String> nombresRoles = Arrays.asList("ALUMNO", "PROFESOR", "PADRE", "ADMINISTRATIVO");

        for (String nombreRol : nombresRoles) {
            Rol rol = rolRepositorio.findByNombre(nombreRol);
            if (rol == null) {
                rol = new Rol();
                rol.setNombre(nombreRol);
                rolRepositorio.save(rol);
            }
        }
    }
}