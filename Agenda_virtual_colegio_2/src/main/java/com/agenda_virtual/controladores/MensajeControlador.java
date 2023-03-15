package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Mensaje;
import com.agenda_virtual.servicios.MensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mensajes")
public class MensajeControlador {

    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping
    public String mostrarMensajes(Model model) {
        model.addAttribute("mensajes", mensajeServicio.obtenerTodosMensajes());
        return "mensajes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoMensaje() {
        return "nuevoMensaje";
    }

    @PostMapping("/nuevo")
    public String enviarMensaje(Mensaje mensaje) {
        mensajeServicio.enviarMensaje(mensaje);
        return "redirect:/mensajes";
    }
}