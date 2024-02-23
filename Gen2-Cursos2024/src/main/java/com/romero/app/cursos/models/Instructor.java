package com.romero.app.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "jpa_instructores")
public class Instructor {
	@Column(name =  "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ2")
	@SequenceGenerator(sequenceName = "customer_seq2",allocationSize = 1,name = "CUST_SEQ2")
	private Long id;
	
	@NotEmpty(message = "Nombre es requerido")
	private String nombre;
	
	@NotEmpty(message = "Ap Paterno es requerido")
	private String apPaterno;
	
	@NotEmpty(message = "Ap Materno es requerido")
	@Column(name = "ap_materno")
	private String apMaterno;
	
	@NotEmpty(message = "Correo es requerido")
	@Email(message = "Favor de ingresar un correo valido")
	private String email;
	
	@NotEmpty(message = "Telefono es requirdo")
	private String telefono;
	
	@Column(name="horas")
	private Double horas;
	
	@NotEmpty(message = "El codigo es requerido")
	@Pattern ( regexp = "^[a-zA-Z]{3}-[0-9]{4}",message="El codigo debe cumplir con el formato XXX-0000")
	@Column(name = "codigo_instuctor")
	private String codigoIntructor;
	
	@Column(name = "url_foto")
	private String urlFoto;

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

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}

	public String getCodigoIntructor() {
		return codigoIntructor;
	}

	public void setCodigoIntructor(String codigoIntructor) {
		this.codigoIntructor = codigoIntructor;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	

}
