package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Nota;
import com.agenda_virtual.repositorios.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServicio {

    @Autowired
    private NotaRepositorio notaRepositorio;

    public List<Nota> obtenerTodasNotas() {
        return notaRepositorio.findAll();
    }

    public Nota guardarNota(Nota nota) {
        return notaRepositorio.save(nota);
    }
}
