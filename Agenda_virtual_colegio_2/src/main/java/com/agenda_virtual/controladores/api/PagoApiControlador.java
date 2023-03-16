package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Pago;
import com.agenda_virtual.servicios.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoApiControlador {

    @Autowired
    private PagoServicio pagoServicio;

    @GetMapping
    public ResponseEntity<List<Pago>> obtenerTodosPagos() {
        List<Pago> pagos = pagoServicio.obtenerTodosPagos();
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPagoPorId(@PathVariable("id") Long id) {
        Optional<Pago> pago = pagoServicio.obtenerPagoPorId(id);
        return pago.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        Pago nuevoPago = pagoServicio.guardarPago(pago);
        return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizarPago(@PathVariable("id") Long id, @RequestBody Pago pagoActualizado) {
        Optional<Pago> pagoExistente = pagoServicio.obtenerPagoPorId(id);

        if (pagoExistente.isPresent()) {
            Pago pago = pagoExistente.get();
            pago.setAlumno(pagoActualizado.getAlumno());
            pago.setMonto(pagoActualizado.getMonto());
            pago.setFecha(pagoActualizado.getFecha());
            pago.setDescripcion(pagoActualizado.getDescripcion());
            pagoServicio.guardarPago(pago);
            return new ResponseEntity<>(pago, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable("id") Long id) {
        Optional<Pago> pago = pagoServicio.obtenerPagoPorId(id);
        if (pago.isPresent()) {
            pagoServicio.eliminarPago(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
