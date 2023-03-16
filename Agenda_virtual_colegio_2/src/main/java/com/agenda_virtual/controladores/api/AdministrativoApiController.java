package com.agenda_virtual.controladores.api;

import com.agenda_virtual.modelos.Administrativo;
import com.agenda_virtual.servicios.AdministrativoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrativos")
public class AdministrativoApiController {

    @Autowired
    private AdministrativoServicio administrativoServicio;

    // Obtener todos los administrativos
    @GetMapping
    public ResponseEntity<List<Administrativo>> obtenerTodos() {
        List<Administrativo> administrativos = administrativoServicio.findAll();
        return ResponseEntity.ok(administrativos);
    }

    // Obtener un administrativo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Administrativo> obtenerPorId(@PathVariable Long id) {
        Administrativo administrativo = administrativoServicio.obtenerPorId(id);
        if (administrativo != null) {
            return ResponseEntity.ok(administrativo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Crear un administrativo
    @PostMapping
    public ResponseEntity<Administrativo> crear(@RequestBody Administrativo administrativo) {
        Administrativo nuevoAdministrativo = administrativoServicio.guardar(administrativo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAdministrativo);
    }

    // Actualizar un administrativo
    @PutMapping("/{id}")
    public ResponseEntity<Administrativo> actualizar(@PathVariable Long id, @RequestBody Administrativo administrativoActualizado) {
        Administrativo administrativo = administrativoServicio.actualizar(id, administrativoActualizado);
        if (administrativo != null) {
            return ResponseEntity.ok(administrativo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un administrativo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        administrativoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
