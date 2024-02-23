package com.romero.app.proyecto.controllers;


import com.romero.app.proyecto.models.Vuelo;
import com.romero.app.proyecto.sevices.clases.VueloServices;
import com.romero.app.proyecto.utils.enums.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuelo")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    VueloServices vueloServices;
    
    @PostMapping
    public String postvuelo(@RequestBody Vuelo vuelo){

        String cad = "";

        try{
            this.vueloServices.guardar(vuelo);
            cad = "vuelo agregado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }

        return cad;
    }

    @GetMapping
    public List<Vuelo> listaVuerlos(){
        return vueloServices.listar();
    }

    @GetMapping("/{estado}")
    public List<Vuelo> listaVuelosEstado( @PathVariable(name = "estado") Estado estado){
        return vueloServices.listarPorEstado(estado);
    }

    @PutMapping
    public String putVuelo(@RequestBody Vuelo vuelo){
        String cad = "";
        try{
            this.vueloServices.guardar(vuelo);
            cad = "vuelo actualizado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }
        return cad;
    }

    @DeleteMapping("/{id}")
    public String deleteAvion(@PathVariable(name = "id")Long id){
        String cad = "";
        try{
            this.vueloServices.eliminar(id);
            cad = "vuelo eliminado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }
        return cad;
    }
}
