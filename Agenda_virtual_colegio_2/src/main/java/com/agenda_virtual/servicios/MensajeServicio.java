package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Mensaje;
import com.agenda_virtual.repositorios.MensajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeServicio {

    @Autowired
    private MensajeRepositorio mensajeRepositorio;

    public List<Mensaje> obtenerTodosMensajes() {
        return mensajeRepositorio.findAll();
    }

    public Mensaje enviarMensaje(Mensaje mensaje) {
        return mensajeRepositorio.save(mensaje);
    }

    public Optional<Mensaje> obtenerMensajePorId(Long id) {
        return mensajeRepositorio.findById(id);
    }

    public void eliminarMensaje(Long id) {
        mensajeRepositorio.deleteById(id);
    }
}