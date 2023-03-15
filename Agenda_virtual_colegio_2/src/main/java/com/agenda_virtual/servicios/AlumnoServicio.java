package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.repositorios.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServicio {

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    public List<Alumno> findAll() {
        return alumnoRepositorio.findAll();
    }

    public Alumno findById(Long id) {
        Optional<Alumno> alumno = alumnoRepositorio.findById(id);
        return alumno.orElse(null);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    public Alumno update(Long id, Alumno alumnoActualizado) {
        Optional<Alumno> alumnoOptional = alumnoRepositorio.findById(id);

        if (alumnoOptional.isPresent()) {
            Alumno alumno = alumnoOptional.get();
            alumno.setNombre(alumnoActualizado.getNombre());
            alumno.setApellido(alumnoActualizado.getApellido());
            alumno.setCorreoElectronico(alumnoActualizado.getCorreoElectronico());
            alumno.setContrasena(alumnoActualizado.getContrasena());
            alumno.setGrado(alumnoActualizado.getGrado());
            alumno.setSeccion(alumnoActualizado.getSeccion());
            alumno.setNotas(alumnoActualizado.getNotas());
            alumno.setTareas(alumnoActualizado.getTareas());
            return alumnoRepositorio.save(alumno);
        }

        return null;
    }

    public void delete(Long id) {
        alumnoRepositorio.deleteById(id);
    }
}