package com.agenda_virtual.modelos;

import java.time.LocalDateTime;

public class Mensaje {
    private int id;
    private String asunto;
    private String contenido;
    private LocalDateTime fechaEnvio;
    private Usuario remitente;
    private Usuario destinatario;

    public Mensaje(int id, String asunto, String contenido, LocalDateTime fechaEnvio, Usuario remitente, Usuario destinatario) {
        this.id = id;
        this.asunto = asunto;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", asunto='" + asunto + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                ", remitente=" + remitente +
                ", destinatario=" + destinatario +
                '}';
    }
}

