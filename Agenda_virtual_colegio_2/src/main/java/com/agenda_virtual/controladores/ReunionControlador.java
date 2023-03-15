package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.modelos.Profesor;
import com.agenda_virtual.modelos.Reunion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReunionControlador {

    // Simula una base de datos de reuniones para propósitos de ejemplo
    private List<Reunion> reuniones;

    public ReunionControlador() {
        // Inicializar la lista de reuniones (en lugar de esto, se podría acceder a una base de datos real)
        reuniones = new ArrayList<>();
    }

    // Método para programar una reunión
    public boolean programarReunion(Reunion reunion) {
        // En una aplicación real, aquí se insertaría la reunión en la base de datos
        return reuniones.add(reunion);
    }

    // Método para actualizar una reunión
    public boolean actualizarReunion(Reunion reunionActualizada) {
        // En una aplicación real, aquí se actualizaría la reunión en la base de datos
        for (int i = 0; i < reuniones.size(); i++) {
            if (reuniones.get(i).getId() == reunionActualizada.getId()) {
                reuniones.set(i, reunionActualizada);
                return true;
            }
        }
        return false;
    }

    // Método para obtener reuniones de un alumno
    public List<Reunion> obtenerReunionesAlumno(Alumno alumno) {
        return reuniones.stream()
                .filter(reunion -> reunion.getAlumno().equals(alumno))
                .collect(Collectors.toList());
    }

    // Método para obtener reuniones de un profesor
    public List<Reunion> obtenerReunionesProfesor(Profesor profesor) {
        return reuniones.stream()
                .filter(reunion -> reunion.getProfesor().equals(profesor))
                .collect(Collectors.toList());
    }
}

