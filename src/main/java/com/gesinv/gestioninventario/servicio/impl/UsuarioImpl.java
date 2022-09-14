package com.gesinv.gestioninventario.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Usuario;
import com.gesinv.gestioninventario.repository.IUsuarioRepo;
import com.gesinv.gestioninventario.servicio.IUsuarioServicio;

public class UsuarioImpl implements IUsuarioServicio {

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public Usuario anadir(Usuario usuario) throws InventarioException {
		// TODO Auto-generated method stub
		return usuarioRepo.save(usuario);
	}

	@Override
	public Usuario modificar(Usuario usuario) throws InventarioException {
		// TODO Auto-generated method stub
		return usuarioRepo.save(usuario);
	}

	@Override
	public void eliminar(Integer id) throws InventarioException {
		// TODO Auto-generated method stub
		usuarioRepo.deleteById(id);

		
	}

	@Override
	public Usuario buscarPorId(Integer id) throws InventarioException {
		// TODO Auto-generated method stub
		return usuarioRepo.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> listar() throws InventarioException {
		// TODO Auto-generated method stub
		return usuarioRepo.findAll();
	}

}
