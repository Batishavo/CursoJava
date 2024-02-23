package com.romero.app.jpa.controllers;

import com.romero.app.jpa.models.Estadisticas;
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
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    @Autowired
    IService<Estadisticas> estadisticasIService;

    @PostMapping
    public ResponseEntity<Map<String,String>> guradar(@RequestBody Estadisticas estadisticas){
        estadisticasIService.guardar(estadisticas);
        Map<String,String> respuesta = new HashMap<>();
        if(estadisticas == null){
            respuesta.put("msg","estadisticas nulas");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }
        else{
            respuesta.put("msg","Estadisticas guardada correctamente");
        }
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public List<Estadisticas> listar(){
        return estadisticasIService.listar();
    }

    @GetMapping("/obener/{id}")
    public ResponseEntity<Estadisticas> obtenerPorId(@PathVariable(name = "id")Long id){
        Optional<Estadisticas> estadisticas = estadisticasIService.getById(id);
        if(estadisticas.isPresent()){
            return ResponseEntity.ok(estadisticas.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String,String>> actualizar(@RequestBody Estadisticas e, @PathVariable(name = "id")Long id){
        Optional<Estadisticas> estadisticas = estadisticasIService.getById(id);
        if(estadisticas.isPresent()){
            e.setId(id);
            estadisticasIService.guardar(e);
        }
        Map<String,String> respuesta = new HashMap<>();
        respuesta.put("msg","Estadistica actualizada correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String,String>> eliminar(@PathVariable(name = "id")Long id){
        Optional<Estadisticas> estadisticas = estadisticasIService.getById(id);
        Map<String,String> respuesta = new HashMap<>();
        if(estadisticas.isPresent()){
            estadisticasIService.eliminar(id);
            respuesta.put("msg","estadistica elminada correctamente");
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.badRequest().header("msg","id no valido").build();
    }

}
