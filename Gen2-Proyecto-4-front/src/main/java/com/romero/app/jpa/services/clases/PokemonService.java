package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IPokemonDao;
import com.romero.app.jpa.dtos.PokemonDtos;
import com.romero.app.jpa.models.Pokemon;
import com.romero.app.jpa.services.interfaces.IPokmemon;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PokemonService implements IPokmemon<Pokemon, PokemonDtos> {

    @Autowired
    private IPokemonDao pokemonDao;

    @Override
    public List<Pokemon> listar() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons = (List<Pokemon>) pokemonDao.findAll();
        return  pokemons;
    }

    @Override
    public Optional<Pokemon> getById(Long id) {
        Optional<Pokemon> pokemon = pokemonDao.findById(id);
        return  pokemon;
    }

    @Override
    public void guardar(PokemonDtos pokemonDtos) {
        this.pokemonDao.save(dtoToObject(pokemonDtos));
    }

    @Override
    public void eliminar(Long id) {
        this.pokemonDao.deleteById(id);
    }

    private Pokemon dtoToObject(PokemonDtos pokemonDtos){
        Pokemon pokemon = new Pokemon();

        return pokemon;
    }


}
