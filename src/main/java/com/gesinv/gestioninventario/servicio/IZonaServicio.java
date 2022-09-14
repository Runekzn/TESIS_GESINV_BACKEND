package com.gesinv.gestioninventario.servicio;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Zona;

import java.util.List;

public interface IZonaServicio {
	
	Zona anadir(Zona zona) throws InventarioException;
	Zona modificar(Zona zona) throws InventarioException;
	void eliminar(Integer id) throws InventarioException;
	Zona buscarPorId(Integer id) throws InventarioException;
	List<Zona> listar() throws InventarioException;
}
