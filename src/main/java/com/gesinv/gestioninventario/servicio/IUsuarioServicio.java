package com.gesinv.gestioninventario.servicio;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {	
	
	Usuario anadir(Usuario usuario) throws InventarioException;
	Usuario modificar(Usuario usuario) throws InventarioException;
	void eliminar(Integer id) throws InventarioException;
	Usuario buscarPorId(Integer id) throws InventarioException;
	List<Usuario> listar() throws InventarioException;
}
