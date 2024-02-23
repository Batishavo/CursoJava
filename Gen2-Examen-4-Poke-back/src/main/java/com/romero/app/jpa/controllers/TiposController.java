package com.romero.app.jpa.controllers;

import com.romero.app.jpa.Enums.TipoPokemon;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
@CrossOrigin(origins = "*")
public class TiposController {

    @Autowired
    IService<TipoPokemon> tipoPokemonIService;

    @GetMapping
    public List<TipoPokemon> listar(){
        return tipoPokemonIService.listar();
    }

}
