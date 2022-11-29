package com.cdi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_generos")
@Entity
public class Genero {
	@Id
	private int idgeneros;
	private String genero;
}
