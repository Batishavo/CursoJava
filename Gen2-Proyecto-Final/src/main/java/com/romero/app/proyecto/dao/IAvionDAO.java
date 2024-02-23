package com.romero.app.proyecto.dao;

import com.romero.app.proyecto.models.Avion;
import org.springframework.data.repository.CrudRepository;

public interface IAvionDAO extends CrudRepository<Avion,String> {
}
