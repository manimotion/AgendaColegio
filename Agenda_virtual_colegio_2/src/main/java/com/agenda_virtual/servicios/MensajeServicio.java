package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Mensaje;
import com.agenda_virtual.repositorios.MensajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}