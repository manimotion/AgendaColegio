package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MensajeRepositorio extends JpaRepository<Mensaje, Long> {
    Optional<Mensaje> findById(Long id);
}