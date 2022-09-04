package com.gesinv.gestioninventario.dto;

import com.gesinv.gestioninventario.modelo.Categoria;
import com.gesinv.gestioninventario.modelo.Marca;
import com.gesinv.gestioninventario.modelo.Proveedor;
import com.gesinv.gestioninventario.modelo.Zona;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter

public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private String codigo;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private String imagen;
    private Integer iva;
    private Proveedor proveedor;
    private Categoria categoria;
    private Marca marca;
    private Zona zona;
}