package com.gesinv.gestioninventario.servicio;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Proveedor;

import java.util.List;

public interface IProveedorServicio {
    Proveedor anadir(Proveedor proveedor) throws InventarioException ;
    Proveedor modificar(Proveedor proveedor) throws InventarioException ;
    void eliminar(Integer id) throws InventarioException ;
    Proveedor buscarPorId(Integer id) throws InventarioException ;
    List<Proveedor> listar() throws InventarioException ;
}
