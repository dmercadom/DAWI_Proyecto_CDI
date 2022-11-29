package com.cdi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_estado")
@Entity
public class Estado {
	@Id
	private int idestado;
	private String estado;
}
