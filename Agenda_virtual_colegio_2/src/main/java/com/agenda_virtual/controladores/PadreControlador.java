package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Padre;
import com.agenda_virtual.servicios.PadreServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/padres")
public class PadreControlador {

    @Autowired
    private PadreServicio padreServicio;

    @GetMapping
    public String mostrarPadres(Model model) {
        model.addAttribute("padres", padreServicio.obtenerTodosPadres());
        return "padres";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPadre() {
        return "nuevoPadre";
    }

    @PostMapping("/nuevo")
    public String guardarPadre(Padre padre) {
        padreServicio.guardarPadre(padre);
        return "redirect:/padres";
    }
}
