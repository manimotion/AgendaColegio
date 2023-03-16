package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findById(Long id);
}