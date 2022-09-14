package com.gesinv.gestioninventario.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Marca;
import com.gesinv.gestioninventario.repository.IMarcaRepo;
import com.gesinv.gestioninventario.servicio.IMarcaServicio;

@Service

public class MarcaImpl implements IMarcaServicio {

	@Autowired
    private IMarcaRepo marcaRepo;

    @Override
    public Marca anadir(Marca marca) throws InventarioException {
        return marcaRepo.save(marca);
    }

    @Override
    public Marca modificar(Marca marca) throws InventarioException {
        return marcaRepo.save(marca);
    }

    @Override
    public void eliminar(Integer Id) throws InventarioException {
    	marcaRepo.deleteById(Id);
    }

    @Override
    public Marca buscarPorId(Integer id) throws InventarioException {
        return marcaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Marca> listar() throws InventarioException{
        return marcaRepo.findAll();
    }
}
