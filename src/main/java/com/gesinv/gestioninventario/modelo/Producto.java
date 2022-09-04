package com.gesinv.gestioninventario.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Setter
@Getter
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombre;
    private String codigo;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private String imagen;
    private Integer iva;

    @ManyToOne
    @JoinColumn(name = "proveedor_id_proveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "categoria_id_categoria")
    private Categoria categoria;


    @ManyToOne
    @JoinColumn(name = "marca_id_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "zona_id_zona")
    private Zona zona;
}
