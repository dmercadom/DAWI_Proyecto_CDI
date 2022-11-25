package com.cdi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_acceso")
@Entity
public class Acceso {

	@Id
	private int idaccess;
	private String descripcion;
}
