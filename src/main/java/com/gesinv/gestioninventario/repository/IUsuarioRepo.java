package com.gesinv.gestioninventario.repository;

import com.gesinv.gestioninventario.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {


}
