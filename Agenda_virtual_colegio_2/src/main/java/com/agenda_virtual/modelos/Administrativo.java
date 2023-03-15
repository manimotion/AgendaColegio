package com.agenda_virtual.modelos;

public class Administrativo extends Usuario {
    private String cargo;
    private String departamento;

    public Administrativo(int id, String nombre, String apellido, String correoElectronico, String contraseña, String cargo, String departamento) {
        super(id, nombre, apellido, correoElectronico, contraseña);
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "cargo='" + cargo + '\'' +
                ", departamento='" + departamento + '\'' +
                "} " + super.toString();
    }
}
