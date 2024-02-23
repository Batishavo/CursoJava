package com.romero.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.romero.app.jpa.models.DetalleVenta;

public interface IDetalleVentaDatos extends CrudRepository<DetalleVenta, Long>{

}
