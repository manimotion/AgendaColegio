package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
}
