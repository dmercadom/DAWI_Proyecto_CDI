package com.cdi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_categoria")
@Entity
public class Categoria {

	@Id
	private int idcategoria;
	private String categoria;
}
