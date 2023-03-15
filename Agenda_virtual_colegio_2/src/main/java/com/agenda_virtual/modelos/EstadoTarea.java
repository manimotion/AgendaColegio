package com.agenda_virtual.modelos;

public enum EstadoTarea {
    PENDIENTE("Pendiente"),
    EN_PROGRESO("En progreso"),
    COMPLETADA("Completada"),
    ATRASADA("Atrasada");

    private String descripcion;

    EstadoTarea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

