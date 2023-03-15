package com.agenda_virtual.controladores;


import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.modelos.Mensaje;
import com.agenda_virtual.modelos.Profesor;
import com.agenda_virtual.modelos.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MensajeControlador {

    // Simula una base de datos de mensajes para propósitos de ejemplo
    private List<Mensaje> mensajes;

    public MensajeControlador() {
        // Inicializar la lista de mensajes (en lugar de esto, se podría acceder a una base de datos real)
        mensajes = new ArrayList<>();

        // Agregar algunos mensajes de ejemplo a la lista (esto debería reemplazarse por una consulta a la base de datos)
        Usuario remitente = new Profesor(1, "John", "Doe", "profesor@example.com", "profesor123", "Matemáticas");
        Usuario destinatario = new Alumno(2, "Jane", "Doe", "alumno@example.com", "alumno123", 10, "A");
        mensajes.add(new Mensaje(1, "Bienvenido al colegio", "Esperamos que tengas un buen año escolar", LocalDateTime.now(), remitente, destinatario));
    }

    // Método para enviar un mensaje
    public boolean enviarMensaje(Mensaje mensaje) {
        // En una aplicación real, aquí se insertaría el mensaje en la base de datos
        return mensajes.add(mensaje);
    }

    // Método para recibir mensajes de un usuario
    public List<Mensaje> recibirMensajes(Usuario destinatario) {
        return mensajes.stream()
                .filter(mensaje -> mensaje.getDestinatario().equals(destinatario))
                .collect(Collectors.toList());
    }
}
