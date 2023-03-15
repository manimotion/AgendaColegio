package com.agenda_virtual.modelos;

import java.util.List;

public class Padre extends Usuario {
    private String telefono;
    private List<Alumno> hijos;

    public Padre(int id, String nombre, String apellido, String correoElectronico, String contraseña, String telefono) {
        super(id, nombre, apellido, correoElectronico, contraseña);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Alumno> getHijos() {
        return hijos;
    }

    public void setHijos(List<Alumno> hijos) {
        this.hijos = hijos;
    }

    // Método para agregar un hijo al padre
    public void agregarHijo(Alumno hijo) {
        hijos.add(hijo);
    }

    // Método para eliminar un hijo del padre
    public void eliminarHijo(Alumno hijo) {
        hijos.remove(hijo);
    }

    @Override
    public String toString() {
        return "Padre{" +
                "telefono='" + telefono + '\'' +
                ", hijos=" + hijos +
                "} " + super.toString();
    }
}
