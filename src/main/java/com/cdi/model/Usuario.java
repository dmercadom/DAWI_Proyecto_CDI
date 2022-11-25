package com.cdi.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_usuarios")
@Entity
public class Usuario {
	
	@Id
	private int idusua;
	private String nomusua;
	private String apeusua;
	private String correo;
	private String clave;
	private Date fecing;
	private int estado;

	@ManyToOne
	@JoinColumn(name = "idtipo", insertable = false, updatable = false)
	private Acceso objAccess; 
}

