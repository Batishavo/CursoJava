package com.romero.app.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.romero.app.jpa.dtos.VentaListDTO;
import com.romero.app.jpa.models.Cliente;
import com.romero.app.jpa.models.Venta;

public interface IVentaDatos extends CrudRepository<Venta, Long> {

	List<VentaListDTO> findByCliente(Long idCliente);
	
}
