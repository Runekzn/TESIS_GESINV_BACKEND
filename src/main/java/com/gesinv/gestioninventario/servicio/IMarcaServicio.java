package com.gesinv.gestioninventario.servicio;

import java.util.List;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Marca;



public interface IMarcaServicio {
	
	Marca anadir(Marca marca) throws InventarioException;
	Marca modificar(Marca marca) throws InventarioException;
	void eliminar(Integer id) throws InventarioException;
	Marca buscarPorId(Integer id) throws InventarioException;
	List<Marca> listar() throws InventarioException;
}
