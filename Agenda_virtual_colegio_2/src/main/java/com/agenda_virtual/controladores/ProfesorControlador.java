package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Profesor;
import com.agenda_virtual.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profesores")
public class ProfesorControlador {

    @Autowired
    private ProfesorServicio profesorServicio;

    @GetMapping
    public String mostrarProfesores(Model model) {
        model.addAttribute("profesores", profesorServicio.obtenerTodosProfesores());
        return "profesores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoProfesor() {
        return "nuevoProfesor";
    }

    @PostMapping("/nuevo")
    public String guardarProfesor(Profesor profesor) {
        profesorServicio.guardarProfesor(profesor);
        return "redirect:/profesores";
    }
}
