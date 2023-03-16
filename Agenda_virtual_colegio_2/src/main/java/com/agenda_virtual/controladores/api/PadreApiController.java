package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Padre;
import com.agenda_virtual.servicios.PadreServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/padres")
public class PadreApiController {

    @Autowired
    private PadreServicio padreServicio;

    @GetMapping
    public ResponseEntity<List<Padre>> obtenerTodosPadres() {
        List<Padre> padres = padreServicio.obtenerTodosPadres();
        return new ResponseEntity<>(padres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Padre> obtenerPadrePorId(@PathVariable("id") Long id) {
        Optional<Padre> padre = padreServicio.obtenerPadrePorId(id);
        return padre.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Padre> crearPadre(@RequestBody Padre padre) {
        Padre nuevoPadre = padreServicio.guardarPadre(padre);
        return new ResponseEntity<>(nuevoPadre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Padre> actualizarPadre(@PathVariable("id") Long id, @RequestBody Padre padreActualizado) {
        Optional<Padre> padreExistente = padreServicio.obtenerPadrePorId(id);

        if (padreExistente.isPresent()) {
            Padre padre = padreExistente.get();
            padre.setTelefono(padreActualizado.getTelefono());
            padre.setUsuario(padreActualizado.getUsuario());
            padreServicio.guardarPadre(padre);
            return new ResponseEntity<>(padre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPadre(@PathVariable("id") Long id) {
        Optional<Padre> padre = padreServicio.obtenerPadrePorId(id);
        if (padre.isPresent()) {
            padreServicio.eliminarPadre(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
