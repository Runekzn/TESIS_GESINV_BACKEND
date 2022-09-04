package com.gesinv.gestioninventario.servicio.impl;



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
    public Proveedor anadir(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    @Override
    public Proveedor modificar(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    @Override
    public void eliminar(Proveedor proveedor) {
        proveedorRepo.delete(proveedor);
    }

    @Override
    public Proveedor buscarPorId(Long id) {
        return proveedorRepo.findById(id).orElse(null);
    }

    @Override
    public List<Proveedor> listar() {
        return proveedorRepo.findAll();
    }
}
