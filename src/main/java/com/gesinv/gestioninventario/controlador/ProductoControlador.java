/**
 * 
 */
package com.gesinv.gestioninventario.controlador;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gesinv.gestioninventario.servicio.IProductoServicio;
import com.gesinv.gestioninventario.dto.ProductoDto;
import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.exception.ModeloNotFoundException;
import com.gesinv.gestioninventario.modelo.Producto;
import com.gesinv.gestioninventario.servicio.IProveedorServicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;


/**
 * @author adri-
 *
 */

@RestController
@RequestMapping("/api/producto")

public class ProductoControlador {
	
	public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";
	
	@Autowired
	private IProductoServicio productoServicio;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<ProductoDto>> obtenerProducto() throws InventarioException{
		List<ProductoDto> listaProducto = productoServicio.listar().
				stream().map(producto -> mapper.map(producto, ProductoDto.class)).collect(Collectors.toList());
		return new ResponseEntity<>(listaProducto, HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<ProductoDto> registrarPorducto(@Valid @RequestBody ProductoDto dtoRequet) throws InventarioException {
    	Producto p = mapper.map(dtoRequet, Producto.class);
    	Producto obj = productoServicio.anadir(p);
    	ProductoDto dtoResponse = mapper.map(obj, ProductoDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ProductoDto> obtenerPorId(@PathVariable("id") Integer id) throws InventarioException {
		ProductoDto dtoResponse;
		Producto obj = productoServicio.buscarPorId(id);
    	
    	if(obj == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
    	}else {
    		dtoResponse = mapper.map(obj, ProductoDto.class);
    	}
    	
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
	
	@PutMapping
    public ResponseEntity<ProductoDto> modificarProducto(@RequestBody ProductoDto dtoRequet) throws InventarioException{
		Producto producto = productoServicio.buscarPorId(dtoRequet.getIdProveedor());
    	if(producto == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequet.getIdProducto());
    	}
    	Producto p = mapper.map(dtoRequet, Producto.class);
    	Producto obj = productoServicio.modificar(p);
    	ProductoDto dtoResponse = mapper.map(obj, ProductoDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Integer id) throws InventarioException{
		Producto proveedor = productoServicio.buscarPorId(id);
    	if(proveedor == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
    	}
    	productoServicio.eliminar(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    }
	
	
}
