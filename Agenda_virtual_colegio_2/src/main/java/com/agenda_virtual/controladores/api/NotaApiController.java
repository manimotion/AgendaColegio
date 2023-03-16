package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Nota;
import com.agenda_virtual.servicios.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class NotaApiController {

    @Autowired
    private NotaServicio notaServicio;

    @GetMapping
    public ResponseEntity<List<Nota>> obtenerTodasNotas() {
        List<Nota> notas = notaServicio.obtenerTodasNotas();
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerNotaPorId(@PathVariable("id") Long id) {
        Optional<Nota> nota = notaServicio.obtenerNotaPorId(id);
        return nota.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaServicio.guardarNota(nota);
        return new ResponseEntity<>(nuevaNota, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable("id") Long id, @RequestBody Nota notaActualizada) {
        Optional<Nota> notaExistente = notaServicio.obtenerNotaPorId(id);

        if (notaExistente.isPresent()) {
            Nota nota = notaExistente.get();
            nota.setTitulo(notaActualizada.getTitulo());
            nota.setValor(notaActualizada.getValor());
            nota.setValorMaximo(notaActualizada.getValorMaximo());
            nota.setAlumno(notaActualizada.getAlumno());
            nota.setProfesor(notaActualizada.getProfesor());
            notaServicio.guardarNota(nota);
            return new ResponseEntity<>(nota, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable("id") Long id) {
        Optional<Nota> nota = notaServicio.obtenerNotaPorId(id);
        if (nota.isPresent()) {
            notaServicio.eliminarNota(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
