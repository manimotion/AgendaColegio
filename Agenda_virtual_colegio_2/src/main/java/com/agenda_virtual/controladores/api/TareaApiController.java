package com.agenda_virtual.controladores.api;

import com.agenda_virtual.modelos.Tarea;
import com.agenda_virtual.servicios.TareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaApiController {

    @Autowired
    private TareaServicio tareaServicio;

    @GetMapping
    public List<Tarea> obtenerTodasTareas() {
        return tareaServicio.obtenerTodasTareas();
    }

    @GetMapping("/{id}")
    public Tarea obtenerTareaPorId(@PathVariable Long id) {
        return tareaServicio.obtenerTareaPorId(id);
    }

    @PostMapping
    public Tarea guardarTarea(@RequestBody Tarea tarea) {
        return tareaServicio.guardarTarea(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        Tarea tarea = tareaServicio.obtenerTareaPorId(id);

        tarea.setAlumno(tareaActualizada.getAlumno());
        tarea.setProfesor(tareaActualizada.getProfesor());
        tarea.setDescripcion(tareaActualizada.getDescripcion());
        tarea.setFechaEntrega(tareaActualizada.getFechaEntrega());
        tarea.setEstado(tareaActualizada.getEstado());

        return tareaServicio.guardarTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaServicio.eliminarTarea(id);
    }
}
