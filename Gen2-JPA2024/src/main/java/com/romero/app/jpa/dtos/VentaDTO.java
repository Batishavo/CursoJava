package com.romero.app.jpa.dtos;

import java.sql.Date;

public class VentaDTO  {

	private Long id;
	private Date fecha; //importar de java util
	private Float subtotal;
	private Float descuento;
	private Float total;
	private String formaPago;
	private Long Cliente;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	public Float getDescuento() {
		return descuento;
	}
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public Long getCliente() {
		return Cliente;
	}
	public void setCliente(Long cliente) {
		Cliente = cliente;
	}
	
	
	
	
}
