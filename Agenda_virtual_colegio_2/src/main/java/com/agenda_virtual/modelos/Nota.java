package com.agenda_virtual.modelos;

public class Nota {
    private int id;
    private String titulo;
    private double valor;
    private double valorMaximo;
    private Alumno alumno;
    private Profesor profesor;

    public Nota(int id, String titulo, double valor, double valorMaximo, Alumno alumno, Profesor profesor) {
        this.id = id;
        this.titulo = titulo;
        this.valor = valor;
        this.valorMaximo = valorMaximo;
        this.alumno = alumno;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(double valorMaximo) {
        this.valorMaximo = valorMaximo;
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

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", valor=" + valor +
                ", valorMaximo=" + valorMaximo +
                ", alumno=" + alumno +
                ", profesor=" + profesor +
                '}';
    }
}

