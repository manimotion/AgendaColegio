package com.agenda_virtual.modelos;

import java.time.LocalDate;

public class Tarea {

    private int id;
    private Alumno alumno;
    private Profesor profesor;
    private String descripcion;
    private LocalDate fechaEntrega;
    private EstadoTarea estado;

    public Tarea(int id, Alumno alumno, Profesor profesor, String descripcion, LocalDate fechaEntrega, EstadoTarea estado) {
        this.id = id;
        this.alumno = alumno;
        this.profesor = profesor;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }
}
