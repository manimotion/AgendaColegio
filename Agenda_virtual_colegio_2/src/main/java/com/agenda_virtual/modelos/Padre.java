package com.agenda_virtual.modelos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "padres")
public class Padre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefono;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL)
    private Set<Alumno> hijos = new HashSet<>();

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Alumno> getHijos() {
        return hijos;
    }

    public void setHijos(Set<Alumno> hijos) {
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
