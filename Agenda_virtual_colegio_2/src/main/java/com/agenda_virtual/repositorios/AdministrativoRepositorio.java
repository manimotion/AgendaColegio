package com.agenda_virtual.repositorios;



import com.agenda_virtual.modelos.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepositorio extends JpaRepository<Administrativo, Long> {
}