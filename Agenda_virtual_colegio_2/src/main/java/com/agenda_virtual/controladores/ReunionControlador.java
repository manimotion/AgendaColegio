package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Reunion;
import com.agenda_virtual.servicios.ReunionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reuniones")
public class ReunionControlador {

    @Autowired
    private ReunionServicio reunionServicio;

    @GetMapping
    public String mostrarReuniones(Model model) {
        model.addAttribute("reuniones", reunionServicio.obtenerTodasReuniones());
        return "reuniones";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaReunion() {
        return "nuevaReunion";
    }

    @PostMapping("/nueva")
    public String guardarReunion(Reunion reunion) {
        reunionServicio.guardarReunion(reunion);
        return "redirect:/reuniones";
    }
}
