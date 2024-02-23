package com.romero.app.jpa.controllers;

import com.romero.app.jpa.dtos.PokemonDtos;
import com.romero.app.jpa.models.Estadisticas;
import com.romero.app.jpa.models.Pokemon;
import com.romero.app.jpa.services.interfaces.IPokmemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "*")
public class PokemonController {

    @Autowired
    IPokmemon<Pokemon, PokemonDtos> pokemonService;

    @PostMapping
    public ResponseEntity<Map<String,String>> guradar(@RequestBody PokemonDtos pokemonDtos){
        pokemonService.guardar(pokemonDtos);
        Map<String,String> respuesta = new HashMap<>();
        if(pokemonDtos == null){
            respuesta.put("msg","pokemon nulo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }
        else{
            respuesta.put("msg","Pokemon guardado correctamente");
        }
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public List<Pokemon> listar(){
        return pokemonService.listar();
    }

    @GetMapping("/obener/{id}")
    public ResponseEntity<Pokemon> obtenerPorId(@PathVariable(name = "id")Long id){
        Optional<Pokemon> estadisticas = pokemonService.getById(id);
        if(estadisticas.isPresent()){
            return ResponseEntity.ok(estadisticas.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/actualizar/{id}")
    public  ResponseEntity<Map<String,String>> actulizar(@RequestBody PokemonDtos e, @PathVariable(name = "id")Long id){
        Optional<Pokemon> pokemon = pokemonService.getById(id);
        if(pokemon.isPresent()){
            e.setId(id);
            pokemonService.guardar(e);
            Map<String,String> respuesta = new HashMap<>();
            respuesta.put("msg","Pokemon actualizado correctamente");
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.badRequest().header("msg","id no valido").build();
        //return pokemon.get();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String,String>> eliminar(@PathVariable(name = "id")Long id){
        Optional<Pokemon> estadisticas = pokemonService.getById(id);
        Map<String,String> respuesta = new HashMap<>();
        if(estadisticas.isPresent()){
            pokemonService.eliminar(id);
            respuesta.put("msg","Pokemon elminado correctamente");
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.badRequest().header("msg","id no valido").build();
    }


}
