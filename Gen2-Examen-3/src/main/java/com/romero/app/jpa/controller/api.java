package com.romero.app.jpa.controller;

import com.romero.app.jpa.dtos.CalificaionesDTO;
import com.romero.app.jpa.models.Calificacion;
import com.romero.app.jpa.models.consultas.ConsultasCalificacion;
import com.romero.app.jpa.models.consultas.ConsultaPromerdio;
import com.romero.app.jpa.services.clases.ConsultasService;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
public class api {
    @Autowired
    IService<Calificacion, CalificaionesDTO> calificacioneIService;

    @Autowired
    ConsultasService consultasService;

    @PostMapping
    public ResponseEntity<Map<String, String>> accionPost(@RequestBody CalificaionesDTO calificacion){
        Map<String, String> response = new HashMap<>();
        try{

            calificacioneIService.guardar(calificacion);
            response.put("success", "ok");
            response.put("msg", "calificacion registrada");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            response.put("failed", "fallo");
            response.put("msg", "datos invalidos");
        }

        return ResponseEntity.badRequest().body(response);

    }

    @GetMapping
    public ConsultaPromerdio accionGet(@RequestParam(name = "id")Long id) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        List<ConsultasCalificacion> calificacions = consultasService.consultasCalificacion(id);
        for (ConsultasCalificacion calificacion : calificacions) {
            Date fecha = formatoFecha.parse(calificacion.getFecha_registro().toString());
            calificacion.setFecha_registro(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
        }

        ConsultaPromerdio consultaPromerdio = new ConsultaPromerdio(calificacions);

        return consultaPromerdio;
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> accionPut(@RequestBody CalificaionesDTO calificacion){
        Map<String, String> response = new HashMap<>();
        try{

            calificacioneIService.guardar(calificacion);
            response.put("success", "ok");
            response.put("msg", "calificacion actualizada");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            response.put("failed", "fallo");
            response.put("msg", "datos invalidos");
        }

        return ResponseEntity.badRequest().body(response);

    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> accionDelete(@RequestParam(name = "id")Long id){
        Map<String, String> response = new HashMap<>();
        try{
            if(calificacioneIService.getById(id).isPresent()){
                calificacioneIService.eliminar(id);
                response.put("success", "ok");
                response.put("msg", "calificacion eliminada");
                return ResponseEntity.ok(response);
            }
            else{
                throw new RuntimeException();
            }

        }
        catch (Exception e){
            response.put("failed", "fallo");
            response.put("msg", "datos invalidos");
        }

        return ResponseEntity.badRequest().body(response);
    }

}
