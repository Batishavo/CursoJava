package com.romero.app.jpa.dao;

import com.romero.app.jpa.models.Habilidad;
import org.springframework.data.repository.CrudRepository;

public interface IHabilidadesDao extends CrudRepository<Habilidad,Long> {
}
