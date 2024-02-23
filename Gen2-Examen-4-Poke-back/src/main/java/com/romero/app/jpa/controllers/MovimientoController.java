package com.romero.app.jpa.controllers;

import com.romero.app.jpa.models.Movimiento;
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
@RequestMapping("/api/movimientos")
@CrossOrigin(origins = "*")
public class MovimientoController {

    @Autowired
    IService<Movimiento> movimientoIService;

    @PostMapping
    public ResponseEntity<Map<String,String>> guardar(@RequestBody Movimiento movimiento){
        movimientoIService.guardar(movimiento);
        Map<String,String> resspuesta = new HashMap<>();
        if(movimiento == null){
            resspuesta.put("msg","Movimiento nulo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resspuesta);
        }
        else{
            resspuesta.put("msg","movimiento guardaddo correctmanete");
        }
        return ResponseEntity.ok(resspuesta);
    }

    @GetMapping
    public List<Movimiento> listar(){
        return movimientoIService.listar();
    }

    @GetMapping("/obtener/{id}")
    public  ResponseEntity<Movimiento> obtenerPorId(@PathVariable(name ="id")Long id){
        Optional<Movimiento> movimiento = movimientoIService.getById(id);
        if(movimiento.isPresent()){
            return ResponseEntity.ok(movimiento.get());
        }
        String resp = "id invalido";
        return ResponseEntity.badRequest().header("msg","id no valido").build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String,String>> actualizar(@RequestBody Movimiento m, @PathVariable(name = "id")Long id){
        Optional<Movimiento> movimiento = movimientoIService.getById(id);
        if(movimiento.isPresent()){
            m.setId(id);
            movimientoIService.guardar(m);
            Map<String,String> respuesta = new HashMap<>();
            respuesta.put("msg","Movimientos actualizado correctamente");
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.badRequest().header("msg","id no valido").build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String,String>> eliminar(@PathVariable(name = "id")Long id){
        Optional<Movimiento> movimiento = movimientoIService.getById(id);
        Map<String,String> respuesta = new HashMap<>();
        if(movimiento.isPresent()){
            movimientoIService.eliminar(id);
            respuesta.put("msg","movimiento elminada correctamente");
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.badRequest().header("msg","id no valido").build();
    }

}
