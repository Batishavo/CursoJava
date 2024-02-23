package com.romero.app.proyecto.dao;

import com.romero.app.proyecto.models.Vuelo;
import com.romero.app.proyecto.utils.enums.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVueloDAO extends CrudRepository<Vuelo,Long> {

    List<Vuelo> findByEstado(Estado estado);
}
