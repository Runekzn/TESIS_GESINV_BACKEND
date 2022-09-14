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


import com.gesinv.gestioninventario.dto.UsuarioDto;
import com.gesinv.gestioninventario.exception.InventarioException;
import com.gesinv.gestioninventario.exception.ModeloNotFoundException;

import com.gesinv.gestioninventario.modelo.Usuario;

import com.gesinv.gestioninventario.servicio.IUsuarioServicio;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioControlador {

public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";
	
    @Autowired
    private IUsuarioServicio usuarioServicio;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obtenerUsuario() throws InventarioException {
        List<UsuarioDto> listaUsuario = usuarioServicio.listar().
                stream().map(usuario -> mapper.map(usuario, UsuarioDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<UsuarioDto> registrarUsuario(@Valid @RequestBody UsuarioDto dtoRequet) throws InventarioException {
    	Usuario u = mapper.map(dtoRequet, Usuario.class);
    	Usuario obj = usuarioServicio.anadir(u);
    	UsuarioDto dtoResponse = mapper.map(obj, UsuarioDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> obtenerPorId(@PathVariable("id") Integer id) throws InventarioException {
    	UsuarioDto dtoResponse;
    	Usuario obj = usuarioServicio.buscarPorId(id);
    	
    	if(obj == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
    	}else {
    		dtoResponse = mapper.map(obj, UsuarioDto.class);
    	}
    	
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<UsuarioDto> modificarUsuario(@RequestBody UsuarioDto dtoRequet) throws InventarioException{
    	Usuario usuario = usuarioServicio.buscarPorId(dtoRequet.getIdUsuario());
    	if(usuario == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequet.getIdUsuario());
    	}
    	Usuario u = mapper.map(dtoRequet, Usuario.class);
    	Usuario obj = usuarioServicio.modificar(u);
    	UsuarioDto dtoResponse = mapper.map(obj, UsuarioDto.class);
    	return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Integer id) throws InventarioException{
    	Usuario usuario = usuarioServicio.buscarPorId(id);
    	if(usuario == null) {
    		throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
    	}
    	usuarioServicio.eliminar(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    }
    
	
}
