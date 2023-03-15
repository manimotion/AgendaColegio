package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepositorio extends JpaRepository<Mensaje, Long> {
}