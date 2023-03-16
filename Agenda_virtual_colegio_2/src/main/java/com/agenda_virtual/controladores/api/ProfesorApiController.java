package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Profesor;
import com.agenda_virtual.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorApiController {

    @Autowired
    private ProfesorServicio profesorServicio;

    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodosProfesores() {
        List<Profesor> profesores = profesorServicio.obtenerTodosProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable("id") Long id) {
        Optional<Profesor> profesor = profesorServicio.obtenerProfesorPorId(id);
        return profesor.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorServicio.guardarProfesor(profesor);
        return new ResponseEntity<>(nuevoProfesor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable("id") Long id, @RequestBody Profesor profesorActualizado) {
        Optional<Profesor> profesorExistente = profesorServicio.obtenerProfesorPorId(id);

        if (profesorExistente.isPresent()) {
            Profesor profesor = profesorExistente.get();
            profesor.setMateria(profesorActualizado.getMateria());
            profesor.setUsuario(profesorActualizado.getUsuario());
            profesor.setAlumnosAsignados(profesorActualizado.getAlumnosAsignados());
            profesorServicio.guardarProfesor(profesor);
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable("id") Long id) {
        Optional<Profesor> profesor = profesorServicio.obtenerProfesorPorId(id);
        if (profesor.isPresent()) {
            profesorServicio.eliminarProfesor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
