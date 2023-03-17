package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Rol;
import com.agenda_virtual.repositorios.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServicio {

    @Autowired
    private RolRepositorio rolRepositorio;

    public Rol obtenerRolPorNombre(String nombre) {
        return rolRepositorio.findByNombre(nombre);
    }
}