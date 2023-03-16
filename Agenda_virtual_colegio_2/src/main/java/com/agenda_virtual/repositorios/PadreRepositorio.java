package com.agenda_virtual.repositorios;


import com.agenda_virtual.modelos.Padre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PadreRepositorio extends JpaRepository<Padre, Long> {
    Optional<Padre> findById(Long id);
}
