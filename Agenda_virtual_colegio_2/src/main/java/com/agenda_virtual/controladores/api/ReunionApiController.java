package com.agenda_virtual.controladores.api;

import com.agenda_virtual.modelos.Reunion;
import com.agenda_virtual.servicios.ReunionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionApiController {

    @Autowired
    private ReunionServicio reunionServicio;

    @GetMapping
    public List<Reunion> obtenerTodasReuniones() {
        return reunionServicio.obtenerTodasReuniones();
    }

    @GetMapping("/{id}")
    public Reunion obtenerReunionPorId(@PathVariable Long id) {
        return reunionServicio.obtenerReunionPorId(id);
    }

    @PostMapping
    public Reunion guardarReunion(@RequestBody Reunion reunion) {
        return reunionServicio.guardarReunion(reunion);
    }

    @PutMapping("/{id}")
    public Reunion actualizarReunion(@PathVariable Long id, @RequestBody Reunion reunionActualizada) {
        Reunion reunion = reunionServicio.obtenerReunionPorId(id);

        reunion.setProfesor(reunionActualizada.getProfesor());
        reunion.setAlumno(reunionActualizada.getAlumno());
        reunion.setFechaHora(reunionActualizada.getFechaHora());
        reunion.setDescripcion(reunionActualizada.getDescripcion());

        return reunionServicio.guardarReunion(reunion);
    }

    @DeleteMapping("/{id}")
    public void eliminarReunion(@PathVariable Long id) {
        reunionServicio.eliminarReunion(id);
    }
}
