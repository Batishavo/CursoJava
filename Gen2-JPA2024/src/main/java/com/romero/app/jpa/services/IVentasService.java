package com.romero.app.jpa.services;

import java.util.List;

import com.romero.app.jpa.dtos.VentaDTO;
import com.romero.app.jpa.dtos.VentaListDTO;

public interface IVentasService extends IService<VentaListDTO, VentaDTO> {
	
	List<VentaListDTO> findByCiente(Long idCliente);
}
