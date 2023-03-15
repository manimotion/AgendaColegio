package com.agenda_virtual.modelos;

import java.util.List;

public class Alumno extends Usuario {
    private int grado;
    private String seccion;
    private List<Nota> notas;
    private List<Tarea> tareas;

    public Alumno(int id, String nombre, String apellido, String correoElectronico, String contraseña, int grado, String seccion) {
        super(id, nombre, apellido, correoElectronico, contraseña);
        this.grado = grado;
        this.seccion = seccion;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    // Método para agregar una nota al alumno
    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    // Método para agregar una tarea al alumno
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "grado=" + grado +
                ", seccion='" + seccion + '\'' +
                ", notas=" + notas +
                ", tareas=" + tareas +
                "} " + super.toString();
    }
}

