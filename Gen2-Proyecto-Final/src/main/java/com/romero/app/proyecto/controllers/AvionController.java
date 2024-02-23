package com.romero.app.proyecto.controllers;

import com.romero.app.proyecto.models.Avion;
import com.romero.app.proyecto.sevices.clases.AvionServices;
import com.romero.app.proyecto.sevices.interfaces.IService;
import com.romero.app.proyecto.utils.enums.TipoAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/avion")
@CrossOrigin(origins = "*")
public class AvionController {

    @Autowired
    AvionServices avionIService;

    @GetMapping("/tiposAvion")
    public List<TipoAvion> tiposAvion (){
       return avionIService.tiposDeAvion();
    }

    @PostMapping()
    public String postAvios(@RequestBody Avion avion){

        String cad = "";

        try{
            this.avionIService.guardar(avion);
            cad = "Avion agregado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }

        return cad;
    }

    @GetMapping
    public List<Avion> listaAviones(){
        return avionIService.listar();
    }

    @PutMapping
    public String putAvion(@RequestBody Avion avion){
        String cad = "";
        try{
            this.avionIService.guardar(avion);
            cad = "Avion actualizado correctamente";
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
            this.avionIService.eliminar(id);
            cad = "Avion eliminado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }
        return cad;
    }

}
