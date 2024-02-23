package com.romero.app.jpa.controllers;

import com.romero.app.jpa.models.Movimiento;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/movimientos")
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

}
