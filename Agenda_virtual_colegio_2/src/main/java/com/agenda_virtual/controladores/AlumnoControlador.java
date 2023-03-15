package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnoControlador {

    @Autowired
    private AlumnoServicio alumnoServicio;

    @GetMapping
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoServicio.findAll();
        model.addAttribute("alumnos", alumnos);
        return "alumnos/lista";
    }

    @GetMapping("/crear")
    public String crearAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumnos/crear";
    }

    @PostMapping("/crear")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoServicio.save(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{id}")
    public String editarAlumno(@PathVariable("id") Long id, Model model) {
        Alumno alumno = alumnoServicio.findById(id);
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
            return "alumnos/editar";
        } else {
            return "redirect:/alumnos";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarAlumno(@PathVariable("id") Long id, @ModelAttribute("alumno") Alumno alumnoActualizado) {
        alumnoServicio.update(id, alumnoActualizado);
        return "redirect:/alumnos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Long id) {
        alumnoServicio.delete(id);
        return "redirect:/alumnos";
    }
}