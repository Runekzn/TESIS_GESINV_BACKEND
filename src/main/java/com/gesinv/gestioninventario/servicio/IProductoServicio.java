package com.gesinv.gestioninventario.servicio;


import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    Producto anadir(Producto producto) throws InventarioException;
    Producto modificar(Producto producto) throws InventarioException;
    void eliminar(Integer id) throws InventarioException;
    Producto buscarPorId(Integer id) throws InventarioException;
    List<Producto> listar() throws InventarioException;

}
