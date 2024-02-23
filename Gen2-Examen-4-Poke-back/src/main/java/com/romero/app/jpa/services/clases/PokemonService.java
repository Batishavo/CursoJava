package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IEstadisticasDao;
import com.romero.app.jpa.dao.IHabilidadesDao;
import com.romero.app.jpa.dao.IMovimientosDao;
import com.romero.app.jpa.dao.IPokemonDao;
import com.romero.app.jpa.dtos.PokemonDtos;
import com.romero.app.jpa.models.Estadisticas;
import com.romero.app.jpa.models.Movimiento;
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
    @Autowired
    private IMovimientosDao movimientosDao;
    @Autowired
    private IHabilidadesDao habilidadesDao;
    @Autowired
    private IEstadisticasDao estadisticasDao;

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
        Long EstadisticasId =estadisticasDao.save(pokemonDtos.getEstadisticas()).getId();
        
        pokemon.setId(pokemonDtos.getId());
        pokemon.setNombre(pokemonDtos.getNombre());
        pokemon.setTipoPrimario(pokemonDtos.getTipoPrimario());
        pokemon.setTipoSecundario(pokemonDtos.getTipoSecundario());
        pokemon.setAltura(pokemonDtos.getAltura());
        pokemon.setPeso(pokemonDtos.getPeso());
        pokemon.setDescipcion(pokemonDtos.getDescripcion());
        pokemon.setEstadisticas(estadisticasDao.findById(EstadisticasId).get());
        pokemon.setHabilidad(habilidadesDao.findById(pokemonDtos.getHabilidad()).get());
        List<Movimiento> movimientos = new ArrayList<>();
        for(Long i : pokemonDtos.getMovimientos()){
        	//System.out.print("\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n"+movimientosDao.findById(i).get().getNombre());
            movimientos.add(movimientosDao.findById(i).get());
        }
        
        pokemon.setMovimientos(movimientos);
        pokemon.setImagen(pokemonDtos.getImagen());

        return pokemon;
    }


}
