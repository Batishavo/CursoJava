package com.romero.app.jpa.dao;

import com.romero.app.jpa.models.Estadisticas;
import com.romero.app.jpa.models.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface IEstadisticasDao extends CrudRepository<Estadisticas,Long> {
}
