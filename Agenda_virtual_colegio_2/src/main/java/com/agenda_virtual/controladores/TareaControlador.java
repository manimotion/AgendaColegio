package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.modelos.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TareaControlador {

    // Simula una base de datos de tareas para propósitos de ejemplo
    private List<Tarea> tareas;

    public TareaControlador() {
        // Inicializar la lista de tareas (en lugar de esto, se podría acceder a una base de datos real)
        tareas = new ArrayList<>();
    }

    // Método para crear una tarea
    public boolean crearTarea(Tarea tarea) {
        // En una aplicación real, aquí se insertaría la tarea en la base de datos
        return tareas.add(tarea);
    }

    // Método para actualizar una tarea
    public boolean actualizarTarea(Tarea tareaActualizada) {
        // En una aplicación real, aquí se actualizaría la tarea en la base de datos
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == tareaActualizada.getId()) {
                tareas.set(i, tareaActualizada);
                return true;
            }
        }
        return false;
    }

    // Método para eliminar una tarea
    public boolean eliminarTarea(int id) {
        // En una aplicación real, aquí se eliminaría la tarea en la base de datos
        return tareas.removeIf(tarea -> tarea.getId() == id);
    }

    // Método para obtener tareas de un alumno
    public List<Tarea> obtenerTareasAlumno(Alumno alumno) {
        return tareas.stream()
                .filter(tarea -> tarea.getAlumno().equals(alumno))
                .collect(Collectors.toList());
    }
}

