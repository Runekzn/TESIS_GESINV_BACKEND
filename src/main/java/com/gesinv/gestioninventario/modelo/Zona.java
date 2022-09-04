package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "zona")
@Setter
@Getter
public class Zona {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZona;
    private String descripcion;
}
