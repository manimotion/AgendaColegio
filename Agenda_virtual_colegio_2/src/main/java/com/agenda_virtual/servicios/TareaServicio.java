package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Tarea;
import com.agenda_virtual.repositorios.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    public List<Tarea> obtenerTodasTareas() {
        return tareaRepositorio.findAll();
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepositorio.save(tarea);
    }
}

