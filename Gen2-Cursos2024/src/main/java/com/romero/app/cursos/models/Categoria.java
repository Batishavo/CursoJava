package com.romero.app.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "jpa_categoria")
public class Categoria {

	@Column(name =  "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ1")
	@SequenceGenerator(sequenceName = "customer_seq1",allocationSize = 1,name = "CUST_SEQ1")
	private Long id;
	
	@Column
	@NotEmpty()
	@Size(max=45, message = "El nombre no debe exceder los 45 caracteres")
	private String nombre;
	
	@Column(name = "numero_cursos")
	private Integer numeroCuros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroCuros() {
		return numeroCuros;
	}

	public void setNumeroCuros(Integer numeroCuros) {
		this.numeroCuros = numeroCuros;
	}
	
	
}
