package com.romero.app.jpa.dao;

import com.romero.app.jpa.models.Materia;
import org.springframework.data.repository.CrudRepository;

public interface IMateriaDao extends CrudRepository<Materia,Long> {
}
