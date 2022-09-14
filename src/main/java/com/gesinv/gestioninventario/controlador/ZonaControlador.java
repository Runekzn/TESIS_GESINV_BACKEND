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

import com.gesinv.gestioninventario.dto.ZonaDto;
import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.exception.ModeloNotFoundException;
import com.gesinv.gestioninventario.modelo.Zona;
import com.gesinv.gestioninventario.servicio.IZonaServicio;

@RestController
@RequestMapping("/api/zona")

public class ZonaControlador {

public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";
	
    @Autowired
    private IZonaServicio zonaServicio;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ZonaDto>> obtenerZona() throws InventarioException {
        List<ZonaDto> listaZona = zonaServicio.listar().
                stream().map(proveedor -> mapper.map(proveedor, ZonaDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(listaZona, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ZonaDto> registrarZona(@Valid @RequestBody ZonaDto dtoRequet) throws InventarioException {
    	Zona z = mapper.map(dtoRequet, Zona.class);
    	Zona obj = zonaServicio.anadir(z);
    	ZonaDto dtoResponse = mapper.map(obj, ZonaDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ZonaDto> obtenerPorId(@PathVariable("id") Integer id) throws InventarioException {
    	ZonaDto dtoResponse;
    	Zona obj = zonaServicio.buscarPorId(id);
    	
    	if(obj == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
    	}else {
    		dtoResponse = mapper.map(obj, ZonaDto.class);
    	}
    	
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<ZonaDto> modificarZona(@RequestBody ZonaDto dtoRequet) throws InventarioException{
    	Zona zona = zonaServicio.buscarPorId(dtoRequet.getIdZona());
    	if(zona == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequet.getIdZona());
    	}
    	Zona p = mapper.map(dtoRequet, Zona.class);
    	Zona obj = zonaServicio.modificar(p);
    	ZonaDto dtoResponse = mapper.map(obj, ZonaDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarZona(@PathVariable("id") Integer id) throws InventarioException{
    	Zona zona = zonaServicio.buscarPorId(id);
    	if(zona == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
    	}
    	zonaServicio.eliminar(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    }
    
}
