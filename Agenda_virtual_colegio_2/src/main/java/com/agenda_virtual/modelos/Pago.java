package com.agenda_virtual.modelos;

import java.time.LocalDateTime;

public class Pago {

    private int id;
    private Alumno alumno;
    private double monto;
    private LocalDateTime fecha;
    private String descripcion;

    public Pago(int id, Alumno alumno, double monto, LocalDateTime fecha, String descripcion) {
        this.id = id;
        this.alumno = alumno;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

