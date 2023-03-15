package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Nota;
import com.agenda_virtual.servicios.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notas")
public class NotaControlador {

    @Autowired
    private NotaServicio notaServicio;

    @GetMapping
    public String mostrarNotas(Model model) {
        model.addAttribute("notas", notaServicio.obtenerTodasNotas());
        return "notas";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaNota() {
        return "nuevaNota";
    }

    @PostMapping("/nueva")
    public String guardarNota(Nota nota) {
        notaServicio.guardarNota(nota);
        return "redirect:/notas";
    }
}
