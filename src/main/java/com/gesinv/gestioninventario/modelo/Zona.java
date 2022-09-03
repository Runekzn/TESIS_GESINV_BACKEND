package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zona")
@Setter
@Getter
public class Zona {
    @Id
    private Long idZona;
    private String descripcion;
}
