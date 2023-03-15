package com.agenda_virtual.servicios;


import com.agenda_virtual.modelos.Administrativo;
import com.agenda_virtual.repositorios.AdministrativoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativoServicio {

    @Autowired
    private AdministrativoRepositorio administrativoRepositorio;

    public List<Administrativo> obtenerTodos() {
        return administrativoRepositorio.findAll();
    }

    public Administrativo obtenerPorId(Long id) {
        Optional<Administrativo> administrativo = administrativoRepositorio.findById(id);
        return administrativo.orElse(null);
    }

    public void guardar(Administrativo administrativo) {
        administrativoRepositorio.save(administrativo);
    }

    public void actualizar(Long id, Administrativo administrativoActualizado) {
        Optional<Administrativo> administrativo = administrativoRepositorio.findById(id);
        if (administrativo.isPresent()) {
            administrativo.get().setNombre(administrativoActualizado.getNombre());
            administrativo.get().setApellido(administrativoActualizado.getApellido());
            administrativo.get().setCargo(administrativoActualizado.getCargo());
            administrativo.get().setDepartamento(administrativoActualizado.getDepartamento());
            administrativoRepositorio.save(administrativo.get());
        }
    }

    public void eliminar(Long id) {
        administrativoRepositorio.deleteById(id);
    }

    public List<Administrativo> findAll() {
        return administrativoRepositorio.findAll();
    }
}