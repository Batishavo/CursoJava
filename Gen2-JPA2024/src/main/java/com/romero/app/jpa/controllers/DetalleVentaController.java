package com.romero.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.romero.app.jpa.dtos.DetalleVentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romero.app.jpa.models.Cliente;
import com.romero.app.jpa.models.DetalleVenta;
import com.romero.app.jpa.models.Producto;
import com.romero.app.jpa.services.IService;

@RestController
@RequestMapping("/api/detalleVenta")
@CrossOrigin(origins = "*")
public class DetalleVentaController {
	
	@Autowired
	IService<DetalleVenta,DetalleVentaDTO> detalleVentaService;
	
	@PostMapping
	public Map<String,String>guardar(@RequestBody DetalleVentaDTO dp){
		
		detalleVentaService.guardar(dp);
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg","Detale venta guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<DetalleVenta>listar(){
		return detalleVentaService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public DetalleVenta obtnerPorId(@PathVariable(name = "id")Long id) {
		Optional<DetalleVenta> detalleVenta = detalleVentaService.getById(id);
		if(detalleVenta.isPresent()) {
			return detalleVenta.get();
		}
		return null;
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id")Long id){
		detalleVentaService.eliminar(id);
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg", "Respuesta generada correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String,String>actualizar(@RequestBody DetalleVentaDTO dv,@PathVariable(name = "id") Long id){
		
		Optional<DetalleVenta> detalleVenta = detalleVentaService.getById(id);
		if(detalleVenta.isPresent()) {
			dv.setId(id);
			detalleVentaService.guardar(dv);
		}
		else {
			throw new RuntimeException("Detalle venta no exite en la bd");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msga", "Detalle venta actualizado correctamente");
		
		return respuesta;
	}

}
