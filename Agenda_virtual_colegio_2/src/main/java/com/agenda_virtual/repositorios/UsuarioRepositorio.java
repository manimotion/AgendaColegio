package com.agenda_virtual.repositorios;

import com.agenda_virtual.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByCorreoElectronico(String correoElectronico);
}
