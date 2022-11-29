package com.cdi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_marcas")
@Entity
public class Marca {
	@Id
	private int idmarcas;
	private String descripcion;
}
