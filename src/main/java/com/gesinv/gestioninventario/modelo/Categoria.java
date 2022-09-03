package com.gesinv.gestioninventario.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
@Setter
@Getter

public class Categoria {
    @Id
    private Long idCategoria;
    private String descripcion;
}
