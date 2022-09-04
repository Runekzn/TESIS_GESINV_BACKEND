package com.gesinv.gestioninventario.servicio;


import com.gesinv.gestioninventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    Producto anadir(Producto producto);
    Producto modificar(Producto producto);
    void eliminar(Producto producto);
    Producto buscarPorId(Long id);
    List<Producto> listar();

}
