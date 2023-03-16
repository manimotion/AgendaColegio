package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoApiControlador {

    @Autowired
    private AlumnoServicio alumnoServicio;

    @GetMapping
    public List<Alumno> listarAlumnos() {
        return alumnoServicio.findAll();
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoServicio.save(alumno);
    }

    @GetMapping("/{id}")
    public Alumno obtenerAlumno(@PathVariable("id") Long id) {
        return alumnoServicio.findById(id);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable("id") Long id, @RequestBody Alumno alumnoActualizado) {
        return alumnoServicio.update(id, alumnoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable("id") Long id) {
        alumnoServicio.delete(id);
    }
}
