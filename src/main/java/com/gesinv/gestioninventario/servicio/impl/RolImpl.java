package com.gesinv.gestioninventario.servicio.impl;

import org.springframework.stereotype.Service;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Rol;
import com.gesinv.gestioninventario.repository.IRolRepo;
import com.gesinv.gestioninventario.servicio.IRolServicio;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class RolImpl implements IRolServicio{
	@Autowired
	private IRolRepo rolRepo;
	
	@Override
	public Rol anadir(Rol rol) throws InventarioException{
		return rolRepo.save(rol);
	}
	
	@Override
	public Rol editar(Rol rol) throws InventarioException{
        return rolRepo.save(rol);
    }

	@Override
    public void eliminar(Integer id) throws InventarioException {
        rolRepo.deleteById(id);
    }

	@Override
    public Rol buscarPorId(Integer id) throws InventarioException {
        return rolRepo.findById(id).orElse(null);
    }

	@Override
    public List<Rol> listar() throws InventarioException{
        return rolRepo.findAll();
    }
}
