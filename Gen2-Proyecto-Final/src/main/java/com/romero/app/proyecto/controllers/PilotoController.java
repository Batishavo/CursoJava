package com.romero.app.proyecto.controllers;

import com.romero.app.proyecto.models.Avion;
import com.romero.app.proyecto.models.Piloto;
import com.romero.app.proyecto.sevices.clases.PilotoServices;
import com.romero.app.proyecto.utils.enums.Sexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/piloto")
@CrossOrigin(origins = "*")
public class PilotoController {

    @Autowired
    PilotoServices pilotoServices;

    @GetMapping("/sexos")
    public List<Sexo> sexos (){
        return pilotoServices.sexos();
    }

    @PostMapping
    public String postPiloto(@RequestBody Piloto piloto){

        String cad = "";

        try{
            this.pilotoServices.guardar(piloto);
            cad = "Piloto agregado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }

        return cad;
    }

    @GetMapping
    public List<Piloto> listaAviones(){
        return pilotoServices.listar();
    }

    @PutMapping
    public String putAvion(@RequestBody Piloto piloto){
        String cad = "";
        try{
            this.pilotoServices.guardar(piloto);
            cad = "Piloto actualizado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }
        return cad;
    }

    @DeleteMapping("/{id}")
    public String deleteAvion(@PathVariable(name = "id")String id){
        String cad = "";
        try{
            this.pilotoServices.eliminar(id);
            cad = "Piloto eliminado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }
        return cad;
    }

}
