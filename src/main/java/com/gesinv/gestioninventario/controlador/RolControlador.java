package com.gesinv.gestioninventario.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.gesinv.gestioninventario.dto.RolDto;
import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.exception.ModeloNotFoundException;
import com.gesinv.gestioninventario.modelo.Rol;
import com.gesinv.gestioninventario.servicio.IRolServicio;

@RestController
@RequestMapping("/api/rol")

public class RolControlador {
	
public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";
	
    @Autowired
    private IRolServicio rolServicio;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RolDto>> obtenerRol() throws InventarioException {
        List<RolDto> listaRol = rolServicio.listar().
                stream().map(proveedor -> mapper.map(proveedor, RolDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(listaRol, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<RolDto> registrarRol(@Valid @RequestBody RolDto dtoRequet) throws InventarioException {
    	Rol r = mapper.map(dtoRequet, Rol.class);
    	Rol obj = rolServicio.anadir(r);
    	RolDto dtoResponse = mapper.map(obj, RolDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RolDto> obtenerPorId(@PathVariable("id") Integer id) throws InventarioException {
    	RolDto dtoResponse;
    	Rol obj = rolServicio.buscarPorId(id);
    	
    	if(obj == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
    	}else {
    		dtoResponse = mapper.map(obj, RolDto.class);
    	}
    	
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<RolDto> modificarRol(@RequestBody RolDto dtoRequet) throws InventarioException{
    	Rol proveedor = rolServicio.buscarPorId(dtoRequet.getIdRol());
    	if(proveedor == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequet.getIdRol());
    	}
    	Rol p = mapper.map(dtoRequet, Rol.class);
    	Rol obj = rolServicio.editar(p);
    	RolDto dtoResponse = mapper.map(obj, RolDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable("id") Integer id) throws InventarioException{
    	Rol rol = rolServicio.buscarPorId(id);
    	if(rol == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
    	}
    	rolServicio.eliminar(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    }
    
}
