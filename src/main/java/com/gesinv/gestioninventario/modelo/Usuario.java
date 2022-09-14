package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Setter
@Getter

public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombre;
    private String contraseña;
    private Boolean estado;

    @ManyToMany
    private List<Rol> roles;

}
