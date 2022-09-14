package com.gesinv.gestioninventario.repository;

import com.gesinv.gestioninventario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
