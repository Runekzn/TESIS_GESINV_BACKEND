package com.gesinv.gestioninventario.repository;

import com.gesinv.gestioninventario.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepo extends JpaRepository<Categoria, Long> {

}

