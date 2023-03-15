package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Tarea;
import com.agenda_virtual.servicios.TareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tareas")
public class TareaControlador {

    @Autowired
    private TareaServicio tareaServicio;

    @GetMapping
    public String mostrarTareas(Model model) {
        model.addAttribute("tareas", tareaServicio.obtenerTodasTareas());
        return "tareas";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaTarea() {
        return "nuevaTarea";
    }

    @PostMapping("/nueva")
    public String guardarTarea(Tarea tarea) {
        tareaServicio.guardarTarea(tarea);
        return "redirect:/tareas";
    }
}
