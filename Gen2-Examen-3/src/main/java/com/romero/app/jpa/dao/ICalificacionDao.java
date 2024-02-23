package com.romero.app.jpa.dao;

import com.romero.app.jpa.models.Calificacion;
import org.springframework.data.repository.CrudRepository;

public interface ICalificacionDao extends CrudRepository<Calificacion,Long> {
}
