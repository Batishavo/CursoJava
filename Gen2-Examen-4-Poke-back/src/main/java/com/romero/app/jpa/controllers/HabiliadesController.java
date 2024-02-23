package com.romero.app.jpa.controllers;

import com.romero.app.jpa.models.Habilidad;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/havilidades")
@CrossOrigin(origins = "*")
public class HabiliadesController {

    @Autowired
    IService<Habilidad> habilidadIService;

    @PostMapping
    public ResponseEntity<Map<String,String>> guardar(@RequestBody Habilidad habilidad){
        habilidadIService.guardar(habilidad);
        Map<String,String> respuesta = new HashMap<>();
        if(habilidad.getDescripcion()==null || habilidad.getNombre() == null){
            respuesta.put("msg","habildad nula");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);

        }
        else{
            respuesta.put("msg","Habilidad guardada correctamente");
        }

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public List<Habilidad> listar(){
        return habilidadIService.listar();
    }

    @GetMapping("/obtener/{id}")
    public  ResponseEntity<Habilidad> obtenerPorId(@PathVariable(name ="id")Long id){
        Optional<Habilidad> habilidad = habilidadIService.getById(id);
        if(habilidad.isPresent()){
            return ResponseEntity.ok(habilidad.get());
        }
        String resp = "id invalido";
        return ResponseEntity.badRequest().header("msg","id no valido").build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String,String>>actualizar(@RequestBody Habilidad h, @PathVariable(name = "id")Long id){
        Optional<Habilidad> habilidad = habilidadIService.getById(id);
        if(habilidad.isPresent()){
            h.setId(id);
            habilidadIService.guardar(h);
        }
        else{
            return ResponseEntity.badRequest().header("msg","id no valido").build();
        }
        Map<String,String> respuesta = new HashMap<>();
        respuesta.put("msg","Habilidad actualizada correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/elminar/{id}")
    public ResponseEntity<Map<String,String>> eliminar(@PathVariable(name ="id")Long id){
        Optional<Habilidad> habilidad = habilidadIService.getById(id);
        Map<String,String> respuesta = new HashMap<>();
        if(habilidad.isPresent()){
            habilidadIService.eliminar(id);
            respuesta.put("msg","habilidad eliminada correctamente");
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.badRequest().header("msg","id no valido").build();
    }

}
