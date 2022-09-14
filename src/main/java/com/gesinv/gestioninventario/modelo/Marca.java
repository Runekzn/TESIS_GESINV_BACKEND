package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "marca")
@Setter
@Getter

public class Marca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarca;
    private String descripcion;
}
