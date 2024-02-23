package com.romero.app.jpa.dtos;

import com.romero.app.jpa.models.Producto;

public class DetalleVenta2DTO {
	
	private Long id;
	private Integer catnidad;
	private Producto producto;
	
	//get and set
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCatnidad() {
		return catnidad;
	}
	public void setCatnidad(Integer catnidad) {
		this.catnidad = catnidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	

}
