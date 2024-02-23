package com.romero.app.proyecto.dao;

import com.romero.app.proyecto.models.Piloto;
import org.springframework.data.repository.CrudRepository;

public interface IPilotoDAO extends CrudRepository<Piloto,String> {
}
