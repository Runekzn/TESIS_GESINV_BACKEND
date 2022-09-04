package com.gesinv.gestioninventario.servicio;

import com.gesinv.gestioninventario.modelo.Proveedor;

import java.util.List;

public interface IProveedorServicio {
    Proveedor anadir(Proveedor proveedor);
    Proveedor modificar(Proveedor proveedor);
    void eliminar(Proveedor proveedor);
    Proveedor buscarPorId(Long id);
    List<Proveedor> listar();
}
