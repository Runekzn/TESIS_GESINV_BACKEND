package com.gesinv.gestioninventario.servicio;

import java.util.List;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Rol;

public interface IRolServicio {
	
	Rol anadir(Rol rol) throws InventarioException ;
	Rol editar(Rol rol) throws InventarioException ;
	void eliminar(Integer id) throws InventarioException ;
	Rol buscarPorId(Integer id) throws InventarioException ;
	List<Rol> listar() throws InventarioException ;

}
