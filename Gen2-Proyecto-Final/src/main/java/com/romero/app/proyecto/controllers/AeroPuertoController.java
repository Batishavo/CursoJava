package com.romero.app.proyecto.controllers;


import com.romero.app.proyecto.models.AeroPuerto;
import com.romero.app.proyecto.models.Piloto;
import com.romero.app.proyecto.sevices.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aeroPuerto")
@CrossOrigin(origins = "*")
public class AeroPuertoController {

    @Autowired
    IService<AeroPuerto,Long> aeroPuertoIService;

    @PostMapping
    public String postAE(@RequestBody AeroPuerto ae){

        String cad = "";

        try{
            this.aeroPuertoIService.guardar(ae);
            cad = "Aeropuerto agregado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }

        return cad;
    }

    @GetMapping
    public List<AeroPuerto> listaAE(){
        return aeroPuertoIService.listar();
    }

    @PutMapping
    public String putAE(@RequestBody AeroPuerto ae){
        String cad = "";
        try{
            this.aeroPuertoIService.guardar(ae);
            cad = "Aeropuerto actualizado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }
        return cad;
    }

    @DeleteMapping("/{id}")
    public String deleteAeropuerto(@PathVariable(name = "id")Long id){
        String cad = "";
        try{
            this.aeroPuertoIService.eliminar(id);
            cad = "Piloto eliminado correctamente";
        }
        catch (Exception e){
            cad = e.getMessage();
        }
        return cad;
    }
}
