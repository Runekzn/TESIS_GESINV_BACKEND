package com.gesinv.gestioninventario.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedorDto {
    private Integer idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String descripcion;
}
