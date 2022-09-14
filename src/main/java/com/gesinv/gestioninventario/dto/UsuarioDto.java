package com.gesinv.gestioninventario.dto;

import com.gesinv.gestioninventario.modelo.Rol;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class UsuarioDto {
    private Integer idUsuario;
    private String nombre;
    private String contraseña;
    private Boolean estado;
    private List<Rol> roles;

}
