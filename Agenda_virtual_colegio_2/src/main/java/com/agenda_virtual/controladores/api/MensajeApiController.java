package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Mensaje;
import com.agenda_virtual.servicios.MensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeApiController {

    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping
    public ResponseEntity<List<Mensaje>> obtenerTodosMensajes() {
        List<Mensaje> mensajes = mensajeServicio.obtenerTodosMensajes();
        return new ResponseEntity<>(mensajes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtenerMensajePorId(@PathVariable("id") Long id) {
        Optional<Mensaje> mensaje = mensajeServicio.obtenerMensajePorId(id);
        return mensaje.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearMensaje(@RequestBody Mensaje mensaje) {
        Mensaje nuevoMensaje = mensajeServicio.enviarMensaje(mensaje);
        return new ResponseEntity<>(nuevoMensaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> actualizarMensaje(@PathVariable("id") Long id, @RequestBody Mensaje mensajeActualizado) {
        Optional<Mensaje> mensajeExistente = mensajeServicio.obtenerMensajePorId(id);

        if (mensajeExistente.isPresent()) {
            Mensaje mensaje = mensajeExistente.get();
            mensaje.setAsunto(mensajeActualizado.getAsunto());
            mensaje.setContenido(mensajeActualizado.getContenido());
            mensaje.setFechaEnvio(mensajeActualizado.getFechaEnvio());
            mensaje.setRemitente(mensajeActualizado.getRemitente());
            mensaje.setDestinatario(mensajeActualizado.getDestinatario());
            mensajeServicio.enviarMensaje(mensaje);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable("id") Long id) {
        Optional<Mensaje> mensaje = mensajeServicio.obtenerMensajePorId(id);
        if (mensaje.isPresent()) {
            mensajeServicio.eliminarMensaje(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
