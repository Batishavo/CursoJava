package com.romero.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.romero.app.jpa.dao.IClientesDatos;
import com.romero.app.jpa.dao.IProductoDatos;
import com.romero.app.jpa.dao.IVentaDatos;
import com.romero.app.jpa.dtos.DetalleVentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.romero.app.jpa.dao.IDetalleVentaDatos;
import com.romero.app.jpa.models.DetalleVenta;

@Component
public class DetalleVentaService implements IService<DetalleVenta, DetalleVentaDTO> {

	@Autowired
	private IDetalleVentaDatos detalleVentaDao;
	@Autowired
	private IVentaDatos ventasDao;
	@Autowired
	private IProductoDatos productoDao;
	
	@Override
	public List<DetalleVenta> listar() {
		// TODO Auto-generated method stub
		List<DetalleVenta> detalleVenta = new ArrayList<>();
		detalleVenta = (List<DetalleVenta>)detalleVentaDao.findAll();
		return detalleVenta;
	}

	@Override
	public Optional<DetalleVenta> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<DetalleVenta> detalleVenta = detalleVentaDao.findById(id);
		return detalleVenta;
	}

	@Override
	public void guardar(DetalleVentaDTO t) {
		// TODO Auto-generated method stub
		this.detalleVentaDao.save(convertDTOaDetalleVenta(t));
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.detalleVentaDao.deleteById(id);
	}

	public DetalleVenta convertDTOaDetalleVenta(DetalleVentaDTO detalleVentaDTO){
		DetalleVenta dt = new DetalleVenta();

		dt.setId(detalleVentaDTO.getId());
		dt.setCantidad(detalleVentaDTO.getCantidad());
		dt.setProducto(productoDao.findById(detalleVentaDTO.getProducto()).get());
		dt.setVenta(ventasDao.findById(detalleVentaDTO.getVenta()).get());

		return dt;
	}

}
