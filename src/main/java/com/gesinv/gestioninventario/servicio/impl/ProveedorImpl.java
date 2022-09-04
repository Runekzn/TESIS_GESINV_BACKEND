package com.gesinv.gestioninventario.servicio.impl;



import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.modelo.Proveedor;
import com.gesinv.gestioninventario.repository.IProveedorRepo;
import com.gesinv.gestioninventario.servicio.IProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorImpl implements IProveedorServicio {
    @Autowired
    private IProveedorRepo proveedorRepo;

    @Override
    public Proveedor anadir(Proveedor proveedor) throws InventarioException{
        return proveedorRepo.save(proveedor);
    }

    @Override
    public Proveedor modificar(Proveedor proveedor) throws InventarioException{
        return proveedorRepo.save(proveedor);
    }

    @Override
    public void eliminar(Integer id) throws InventarioException {
        proveedorRepo.deleteById(id);
    }

    @Override
    public Proveedor buscarPorId(Integer id) throws InventarioException {
        return proveedorRepo.findById(id).orElse(null);
    }

    @Override
    public List<Proveedor> listar() throws InventarioException{
        return proveedorRepo.findAll();
    }
}
