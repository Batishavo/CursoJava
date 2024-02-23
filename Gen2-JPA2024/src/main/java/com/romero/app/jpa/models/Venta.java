package com.romero.app.jpa.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name = "jpa_ventas")
@Entity
public class Venta {
	
	//atributos -> variables -> caracterirsticas
	
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ3")
	@SequenceGenerator(sequenceName = "customer_seq3",allocationSize = 1,name = "CUST_SEQ3")
	private Long id;
	
	//2
	@Column(name = "fecha")
	private Date fecha; // importar de java util
	
	//2
	@Column(name = "descuento")
	private Float descuento;
	
	//2
	@Column(name = "total")
	private Float total;

	@Column(name = "sub_total")
	private Float subTotal;
	
	//2
	@Column(name = "forma_pago")
	private String formaPago;
	
	//3
	@JoinColumn(name = "cliente_id")
	@ManyToOne
	private Cliente cliente;
	
	//volte os la realcion original
	@OneToMany(mappedBy = "venta")
	private List<DetalleVenta> detalle;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}

	public List<DetalleVenta> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleVenta> detalle) {
		this.detalle = detalle;
	}
	
	

	
	
	
}
