package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.Enums.TipoPokemon;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Component
public class TiposService implements IService<TipoPokemon> {
    @Override
    public List<TipoPokemon> listar() {
        return new ArrayList<TipoPokemon>(EnumSet.allOf(TipoPokemon.class));
    }

    @Override
    public Optional<TipoPokemon> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(TipoPokemon tipoPokemon) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
