package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepositorio extends JpaRepository<Pago, Long> {
}
