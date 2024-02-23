package com.romero.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.romero.app.jpa.dao.IClientesDatos;
import com.romero.app.jpa.dao.IVentaDatos;
import com.romero.app.jpa.dtos.DetalleVenta2DTO;
import com.romero.app.jpa.dtos.VentaDTO;
import com.romero.app.jpa.dtos.VentaListDTO;
import com.romero.app.jpa.models.DetalleVenta;
import com.romero.app.jpa.models.Venta;

@Component
public class VentaService implements IVentasService {

	@Autowired
	private IVentaDatos ventaDao;
	@Autowired
	private IClientesDatos clientesDao;
	
	
	@Override
	public List<VentaListDTO> listar() {
		// TODO Auto-generated method stub
		List<Venta> ventas = new ArrayList<>();
		ventas = (List<Venta>)ventaDao.findAll();
		return ventas.stream().map((v)->{
			return this.convertirVentaADTO(v);
		}).toList();
	}

	@Override
	public Optional<VentaListDTO> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Venta> venta = ventaDao.findById(id);
		return Optional.of(this.convertirVentaADTO(venta.get()));
	}

	@Override
	public void guardar(VentaDTO t) {
		// TODO Auto-generated method stub
		Venta v = convertirDTOaVenta(t);
		this.ventaDao.save(v);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.ventaDao.deleteById(id);
	}
	
	public Venta convertirDTOaVenta(VentaDTO ventadto) {
		
		
		Venta v = new Venta();
		v.setId(ventadto.getId());
		v.setFecha(ventadto.getFecha());
		v.setTotal(ventadto.getTotal());
		v.setDescuento(ventadto.getDescuento());
		v.setFormaPago(ventadto.getFormaPago());
		v.setCliente(clientesDao.findById(ventadto.getCliente()).get());
		
		return v;
	
	}
	
	public VentaListDTO convertirVentaADTO(Venta v) {
		
		VentaListDTO vdto = new VentaListDTO();
		vdto.setId(v.getId());
		vdto.setFecha(v.getFecha());
		vdto.setSubtotal(v.getSubTotal());
		vdto.setDescuento(v.getDescuento());
		vdto.setTotal(v.getTotal());
		vdto.setFormaPago(v.getFormaPago());
		vdto.setCliente(v.getCliente().getId());
		
		List<DetalleVenta2DTO> detalle = new ArrayList<>();
		for(DetalleVenta dv:v.getDetalle()) {
			
			DetalleVenta2DTO dvdto = new DetalleVenta2DTO();
			dvdto.setId(dv.getId());
			dvdto.setCatnidad(dv.getCantidad());
			dvdto.setProducto(dv.getProducto());
			detalle.add(dvdto);
			
		}
		
		vdto.setDetalle(detalle);
		return vdto;
	}

	/*@Override
	public List<VentaListDTO> findByCiente(Long idCliente) {
		// TODO Auto-generated method stub
		List<Venta> ventas = new ArrayList<>();
		ventas = (List<Venta>) ventaDao.findByCliente(idCliente);
		return null;
	}*/

	/*@Override
	public List<VentaListDTO> findByCiente(Long idCliente) {
		// TODO Auto-generated method stub
		List<Venta> ventas = new ArrayList<>();
		ventas = (List<Venta>) ventaDao.findByCliente(clientesDao.findById(idCliente).get());
		
		return ventas.stream().map((v)->{
			return this.convertirVentaADTO(v);
		}).toList();
				
	}*/
}
