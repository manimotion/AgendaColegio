package com.agenda_virtual.modelos;

import java.time.LocalDateTime;

public class Reunion {

    private int id;
    private Profesor profesor;
    private Alumno alumno;
    private LocalDateTime fechaHora;
    private String descripcion;

    public Reunion(int id, Profesor profesor, Alumno alumno, LocalDateTime fechaHora, String descripcion) {
        this.id = id;
        this.profesor = profesor;
        this.alumno = alumno;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

