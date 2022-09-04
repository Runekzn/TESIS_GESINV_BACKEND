package com.gesinv.gestioninventario.controlador;

import com.gesinv.gestioninventario.dto.ProveedorDto;
import com.gesinv.gestioninventario.servicio.IProveedorServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proveedor")

public class ProveedorControlador {

    @Autowired
    private IProveedorServicio proveedorServicio;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> obtenerProveedores() {
        List<ProveedorDto> listaProveedores = proveedorServicio.listar().
                stream().map(proveedor -> mapper.map(proveedor, ProveedorDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(listaProveedores, HttpStatus.OK);
    }

}
