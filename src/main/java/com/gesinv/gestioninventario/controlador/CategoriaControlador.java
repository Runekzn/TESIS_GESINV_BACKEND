package com.gesinv.gestioninventario.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.exception.ModeloNotFoundException;
import com.gesinv.gestioninventario.servicio.ICategoriaServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gesinv.gestioninventario.dto.CategoriaDto;
import com.gesinv.gestioninventario.modelo.Categoria;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaControlador {
	
	public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";
	
	 @Autowired
	    private ICategoriaServicio categoriaServicio;

	    @Autowired
	    private ModelMapper mapper;

	    @GetMapping
	    public ResponseEntity<List<CategoriaDto>> obtenerCategoria() throws InventarioException {
	        List<CategoriaDto> listaCategoria = categoriaServicio.listar().
	                stream().map(proveedor -> mapper.map(proveedor, CategoriaDto.class)).collect(Collectors.toList());
	        return new ResponseEntity<>(listaCategoria, HttpStatus.OK);
	    }
	    
	    @PostMapping
	    public ResponseEntity<CategoriaDto> registrarCategoria(@Valid @RequestBody CategoriaDto dtoRequet) throws InventarioException {
	    	Categoria p = mapper.map(dtoRequet, Categoria.class);
	    	Categoria obj = categoriaServicio.anadir(p);
	    	CategoriaDto dtoResponse = mapper.map(obj, CategoriaDto.class);
	    	return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<CategoriaDto> obtenerPorId(@PathVariable("id") Integer id) throws InventarioException {
	    	CategoriaDto dtoResponse;
	    	Categoria obj = categoriaServicio.buscarPorId(id);
	    	
	    	if(obj == null) {
	    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
	    	}else {
	    		dtoResponse = mapper.map(obj, CategoriaDto.class);
	    	}
	    	
	    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	    }
	    
	    @PutMapping
	    public ResponseEntity<CategoriaDto> modificarCategoria(@RequestBody CategoriaDto dtoRequet) throws InventarioException{
	    	Categoria proveedor = categoriaServicio.buscarPorId(dtoRequet.getIdCategoria());
	    	if(proveedor == null) {
	    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequet.getIdCategoria());
	    	}
	    	Categoria p = mapper.map(dtoRequet, Categoria.class);
	    	Categoria obj = categoriaServicio.modificar(p);
	    	CategoriaDto dtoResponse = mapper.map(obj, CategoriaDto.class);
	    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarCategoria(@PathVariable("id") Integer id) throws InventarioException{
	    	Categoria proveedor = categoriaServicio.buscarPorId(id);
	    	if(proveedor == null) {
	    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
	    	}
	    	categoriaServicio.eliminar(id);
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	
	    }
}
