package com.gesinv.gestioninventario.servicio;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Categoria;
import java.util.List;

public interface ICategoriaServicio {
	
	Categoria anadir(Categoria categoria) throws InventarioException;
	Categoria modificar(Categoria categoria) throws InventarioException;
	void eliminar(Integer Id) throws InventarioException;
	Categoria buscarPorId(Integer id) throws InventarioException;
	List<Categoria> listar() throws InventarioException;
	
}
