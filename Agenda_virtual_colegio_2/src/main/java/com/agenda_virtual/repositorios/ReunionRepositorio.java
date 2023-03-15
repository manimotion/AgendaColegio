package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionRepositorio extends JpaRepository<Reunion, Long> {
}
