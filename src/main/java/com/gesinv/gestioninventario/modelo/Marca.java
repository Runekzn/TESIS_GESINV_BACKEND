package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
@Setter
@Getter

public class Marca {
    @Id
    private Long idMarca;
    private String descripcion;
}
