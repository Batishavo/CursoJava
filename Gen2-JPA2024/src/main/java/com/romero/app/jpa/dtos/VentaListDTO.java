package com.romero.app.jpa.dtos;

import java.sql.Date;
import java.util.List;

import com.romero.app.jpa.models.Cliente;

import ch.qos.logback.core.net.server.Client;

public class VentaListDTO {
	
	private Long id;
	private Date fecha;
	private Float subtotal;
	private Float descuento;
	private Float total;
	private String formaPago;
	private Long cliente;
	private List<DetalleVenta2DTO> detalle;
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
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public List<DetalleVenta2DTO> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleVenta2DTO> detalle) {
		this.detalle = detalle;
	}
	
	
	
}
