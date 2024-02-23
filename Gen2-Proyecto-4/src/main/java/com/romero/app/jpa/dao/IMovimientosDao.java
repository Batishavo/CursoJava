package com.romero.app.jpa.dao;

import com.romero.app.jpa.models.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface IMovimientosDao extends CrudRepository<Movimiento,Long> {
}
