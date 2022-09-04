package com.gesinv.gestioninventario.servicio.impl;

import com.gesinv.gestioninventario.modelo.Producto;
import com.gesinv.gestioninventario.repository.IProductoRepo;
import com.gesinv.gestioninventario.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImpl implements IProductoServicio {


    @Autowired
    private IProductoRepo productoRepo;

    @Override
    public Producto anadir(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto modificar(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        productoRepo.delete(producto);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> listar() {
        return productoRepo.findAll();
    }
}
