package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Long> {
}

