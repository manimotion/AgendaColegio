package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {

    Rol findByNombre(String nombre);

}