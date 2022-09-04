package com.gesinv.gestioninventario.controlador;

import com.gesinv.gestioninventario.dto.ProveedorDto;
import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.exception.ModeloNotFoundException;
import com.gesinv.gestioninventario.modelo.Proveedor;
import com.gesinv.gestioninventario.servicio.IProveedorServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/proveedor")

public class ProveedorControlador {

	public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";
	
    @Autowired
    private IProveedorServicio proveedorServicio;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> obtenerProveedores() throws InventarioException {
        List<ProveedorDto> listaProveedores = proveedorServicio.listar().
                stream().map(proveedor -> mapper.map(proveedor, ProveedorDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(listaProveedores, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ProveedorDto> registrarProveedor(@Valid @RequestBody ProveedorDto dtoRequet) throws InventarioException {
    	Proveedor p = mapper.map(dtoRequet, Proveedor.class);
    	Proveedor obj = proveedorServicio.anadir(p);
    	ProveedorDto dtoResponse = mapper.map(obj, ProveedorDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDto> obtenerPorId(@PathVariable("id") Integer id) throws InventarioException {
    	ProveedorDto dtoResponse;
    	Proveedor obj = proveedorServicio.buscarPorId(id);
    	
    	if(obj == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
    	}else {
    		dtoResponse = mapper.map(obj, ProveedorDto.class);
    	}
    	
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<ProveedorDto> modificarProveedor(@RequestBody ProveedorDto dtoRequet) throws InventarioException{
    	Proveedor proveedor = proveedorServicio.buscarPorId(dtoRequet.getIdProveedor());
    	if(proveedor == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequet.getIdProveedor());
    	}
    	Proveedor p = mapper.map(dtoRequet, Proveedor.class);
    	Proveedor obj = proveedorServicio.modificar(p);
    	ProveedorDto dtoResponse = mapper.map(obj, ProveedorDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable("id") Integer id) throws InventarioException{
    	Proveedor proveedor = proveedorServicio.buscarPorId(id);
    	if(proveedor == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
    	}
    	proveedorServicio.eliminar(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    }
    
}
