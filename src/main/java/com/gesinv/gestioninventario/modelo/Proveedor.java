package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "proveedor")
@Setter
@Getter

public class Proveedor {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String descripcion;
}
