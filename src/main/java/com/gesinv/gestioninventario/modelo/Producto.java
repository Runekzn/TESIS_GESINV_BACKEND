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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombre;
	private String codigo;
	private String descripcion;
	private BigDecimal precio;
	private Integer stock;
	private String imagen;
	private Integer iva;
	@Column(name = "idProveedor")
	private Integer idProveedor;

	@Column(name = "idCategoria")
	private Long idCategoria;

	@Column(name = "idMarca")
	private Long idMarca;

	@Column(name = "idZona")
	private Long idZona;

	@ManyToOne
	@JoinColumn(name = "idProveedor", updatable = false, insertable = false)
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "idCategoria", updatable = false, insertable = false)
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "idMarca", updatable = false, insertable = false)
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "idZona", updatable = false, insertable = false)
	private Zona zona;
}
