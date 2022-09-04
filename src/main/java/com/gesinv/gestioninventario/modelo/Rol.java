package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@Getter
public class Rol {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    private String nombre;


}
