package com.gesinv.gestioninventario.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Categoria;
import com.gesinv.gestioninventario.repository.ICategoriaRepo;
import com.gesinv.gestioninventario.servicio.ICategoriaServicio;

@Service
public class CategoriaImpl implements ICategoriaServicio {
	
	@Autowired
	private ICategoriaRepo categoriaRepo;
	
	@Override
	public Categoria anadir(Categoria categoria) throws InventarioException {
		return categoriaRepo.save(categoria);
	}

	@Override
	public Categoria modificar(Categoria categoria) throws InventarioException {
		// TODO Auto-generated method stub
		return categoriaRepo.save(categoria);
	}

	@Override
	public void eliminar(Integer id) throws InventarioException {
		// TODO Auto-generated method stub
		 categoriaRepo.deleteById(id);
	}

	@Override
	public Categoria buscarPorId(Integer id) throws InventarioException {
		// TODO Auto-generated method stub
		return categoriaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Categoria> listar() throws InventarioException {
		// TODO Auto-generated method stub
		return categoriaRepo.findAll();
	}

	
	
}
