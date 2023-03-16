package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Padre;
import com.agenda_virtual.repositorios.PadreRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PadreServicio {

    @Autowired
    private PadreRepositorio padreRepositorio;

    public List<Padre> obtenerTodosPadres() {
        return padreRepositorio.findAll();
    }

    public Padre guardarPadre(Padre padre) {
        return padreRepositorio.save(padre);
    }

    public Optional<Padre> obtenerPadrePorId(Long id) {
        return padreRepositorio.findById(id);
    }

    public void eliminarPadre(Long id) {
        padreRepositorio.deleteById(id);
    }

}
