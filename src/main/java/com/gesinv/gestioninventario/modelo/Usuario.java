package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Setter
@Getter

public class Usuario {
    @Id
    private Long idUsuario;
    private String nombre;
    private String contraseña;
    private Boolean estado;

}
