package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Profesor;
import com.agenda_virtual.repositorios.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServicio {

    @Autowired
    private ProfesorRepositorio profesorRepositorio;

    public List<Profesor> obtenerTodosProfesores() {
        return profesorRepositorio.findAll();
    }

    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepositorio.save(profesor);
    }

    public Optional<Profesor> obtenerProfesorPorId(Long id) {
        return profesorRepositorio.findById(id);
    }

    public void eliminarProfesor(Long id) {
        profesorRepositorio.deleteById(id);
    }
}

