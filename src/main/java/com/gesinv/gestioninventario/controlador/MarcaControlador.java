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

import com.gesinv.gestioninventario.dto.MarcaDto;
import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.exception.ModeloNotFoundException;
import com.gesinv.gestioninventario.modelo.Marca;
import com.gesinv.gestioninventario.servicio.IMarcaServicio;

@RestController
@RequestMapping("/api/marca")
public class MarcaControlador {

public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";
	
    @Autowired
    private IMarcaServicio marcaServicio;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MarcaDto>> obtenerMarcas() throws InventarioException {
        List<MarcaDto> listaProveedores = marcaServicio.listar().
                stream().map(proveedor -> mapper.map(proveedor, MarcaDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(listaProveedores, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<MarcaDto> registrarProveedor(@Valid @RequestBody MarcaDto dtoRequet) throws InventarioException {
    	Marca p = mapper.map(dtoRequet, Marca.class);
    	Marca obj = marcaServicio.anadir(p);
    	MarcaDto dtoResponse = mapper.map(obj, MarcaDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDto> obtenerPorId(@PathVariable("id") Integer id) throws InventarioException {
    	MarcaDto dtoResponse;
    	Marca obj = marcaServicio.buscarPorId(id);
    	
    	if(obj == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
    	}else {
    		dtoResponse = mapper.map(obj, MarcaDto.class);
    	}
    	
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<MarcaDto> modificarProveedor(@RequestBody MarcaDto dtoRequet) throws InventarioException{
    	Marca proveedor = marcaServicio.buscarPorId(dtoRequet.getIdMarca());
    	if(proveedor == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequet.getIdMarca());
    	}
    	Marca p = mapper.map(dtoRequet, Marca.class);
    	Marca obj = marcaServicio.modificar(p);
    	MarcaDto dtoResponse = mapper.map(obj, MarcaDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable("id") Integer id) throws InventarioException{
    	Marca proveedor = marcaServicio.buscarPorId(id);
    	if(proveedor == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
    	}
    	marcaServicio.eliminar(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    }
	
}
