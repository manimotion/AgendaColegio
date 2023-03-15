package com.agenda_virtual.modelos;

import com.sun.tools.javac.util.List;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materia;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private Set<Alumno> alumnosAsignados = new HashSet<>();
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Set<Alumno> getAlumnosAsignados() {
        return alumnosAsignados;
    }

    public void setAlumnosAsignados(Set<Alumno> alumnosAsignados) {
        this.alumnosAsignados = alumnosAsignados;
    }

    // Método para asignar un alumno al profesor
    public void asignarAlumno(Alumno alumno) {
        alumnosAsignados.add(alumno);
    }

    // Método para eliminar un alumno asignado al profesor
    public void eliminarAlumnoAsignado(Alumno alumno) {
        alumnosAsignados.remove(alumno);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "materia='" + materia + '\'' +
                ", alumnosAsignados=" + alumnosAsignados +
                "} " + super.toString();
    }
}
