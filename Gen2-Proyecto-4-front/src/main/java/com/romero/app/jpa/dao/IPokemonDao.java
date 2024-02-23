package com.romero.app.jpa.dao;

import com.romero.app.jpa.models.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface IPokemonDao extends CrudRepository<Pokemon,Long> {
}
