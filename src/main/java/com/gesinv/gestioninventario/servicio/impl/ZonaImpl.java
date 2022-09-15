package com.gesinv.gestioninventario.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Zona;
import com.gesinv.gestioninventario.repository.IZonaRepo;
import com.gesinv.gestioninventario.servicio.IZonaServicio;
@Service
public class ZonaImpl implements IZonaServicio {

    @Autowired
    private IZonaRepo zonaRepo;

	
	@Override
	public Zona anadir(Zona zona) throws InventarioException {
		// TODO Auto-generated method stub
		return zonaRepo.save(zona);
	}

	@Override
	public Zona modificar(Zona zona) throws InventarioException {
		// TODO Auto-generated method stub
		return zonaRepo.save(zona);
	}

	@Override
	public void eliminar(Integer id) throws InventarioException {
		// TODO Auto-generated method stub
		zonaRepo.deleteById(id);
	}

	@Override
	public Zona buscarPorId(Integer id) throws InventarioException {
		// TODO Auto-generated method stub
		return zonaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Zona> listar() throws InventarioException {
		// TODO Auto-generated method stub
		return zonaRepo.findAll();
	}

}
