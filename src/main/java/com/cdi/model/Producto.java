package com.cdi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_productos")
@Entity
public class Producto {

	@Id
	private int id_prod;
	private String modelo;
	private int talla;
	private int idmarcas;
	private int idestado;
	private int idcategoria;
	private int idgeneros;
		
	// get, set, toString()
	
	@ManyToOne
	@JoinColumn(name = "idmarcas", insertable = false, updatable = false)
	private Marca objMarcas; 
	
	@ManyToOne
	@JoinColumn(name = "idestado", insertable = false, updatable = false)
	private Estado objEstado; 
	
	@ManyToOne
	@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
	private Categoria objCategoria; 
	
	@ManyToOne
	@JoinColumn(name = "idestado", insertable = false, updatable = false)
	private Genero objGenero; 
	
}
