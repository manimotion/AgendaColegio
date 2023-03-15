package com.agenda_virtual.modelos;

import java.util.List;

public class Profesor extends Usuario {
    private String materia;
    private List<Alumno> alumnosAsignados;

    public Profesor(int id, String nombre, String apellido, String correoElectronico, String contraseña, String materia) {
        super(id, nombre, apellido, correoElectronico, contraseña);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Alumno> getAlumnosAsignados() {
        return alumnosAsignados;
    }

    public void setAlumnosAsignados(List<Alumno> alumnosAsignados) {
        this.alumnosAsignados = alumnosAsignados;
    }

    // Método para asignar un alumno al profesor
    public void asignarAlumno(Alumno alumno) {
        alumnosAsignados.add(alumno);
    }

    // Método para eliminar un alumno asignado al profesor
    public void eliminarAlumnoAsignado(Alumno alumno) {
        alumnosAsignados.remove(alumno);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "materia='" + materia + '\'' +
                ", alumnosAsignados=" + alumnosAsignados +
                "} " + super.toString();
    }
}
