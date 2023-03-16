package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Reunion;
import com.agenda_virtual.repositorios.ReunionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReunionServicio {

    @Autowired
    private ReunionRepositorio reunionRepositorio;

    public List<Reunion> obtenerTodasReuniones() {
        return reunionRepositorio.findAll();
    }

    public Reunion guardarReunion(Reunion reunion) {
        return reunionRepositorio.save(reunion);
    }

    public Reunion obtenerReunionPorId(Long id) {
        return reunionRepositorio.findById(id).orElse(null);
    }

    public void eliminarReunion(Long id) {
        reunionRepositorio.deleteById(id);
    }
}

