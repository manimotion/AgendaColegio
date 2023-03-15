package com.agenda_virtual.controladores;


import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.modelos.Nota;
import com.agenda_virtual.modelos.Profesor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotaControlador {

    // Simula una base de datos de notas para propósitos de ejemplo
    private List<Nota> notas;

    public NotaControlador() {
        // Inicializar la lista de notas (en lugar de esto, se podría acceder a una base de datos real)
        notas = new ArrayList<>();
    }

    // Método para agregar una nota
    public boolean agregarNota(Nota nota) {
        // En una aplicación real, aquí se insertaría la nota en la base de datos
        return notas.add(nota);
    }

    // Método para actualizar una nota
    public boolean actualizarNota(Nota notaActualizada) {
        // En una aplicación real, aquí se actualizaría la nota en la base de datos
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getId() == notaActualizada.getId()) {
                notas.set(i, notaActualizada);
                return true;
            }
        }
        return false;
    }

    // Método para obtener notas de un alumno
    public List<Nota> obtenerNotasAlumno(Alumno alumno) {
        return notas.stream()
                .filter(nota -> nota.getAlumno().equals(alumno))
                .collect(Collectors.toList());
    }

    // Método para obtener notas asignadas por un profesor
    public List<Nota> obtenerNotasProfesor(Profesor profesor) {
        return notas.stream()
                .filter(nota -> nota.getProfesor().equals(profesor))
                .collect(Collectors.toList());
    }
}

