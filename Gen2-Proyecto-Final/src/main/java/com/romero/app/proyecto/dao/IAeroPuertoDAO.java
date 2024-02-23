package com.romero.app.proyecto.dao;

import com.romero.app.proyecto.models.AeroPuerto;
import org.springframework.data.repository.CrudRepository;

public interface IAeroPuertoDAO extends CrudRepository<AeroPuerto,Long> {
}
