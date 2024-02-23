package com.romero.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.romero.app.jpa.dtos.VentaDTO;
import com.romero.app.jpa.dtos.VentaListDTO;
import com.romero.app.jpa.models.Cliente;
import com.romero.app.jpa.models.Producto;
import com.romero.app.jpa.models.Venta;
import com.romero.app.jpa.services.IService;
import com.romero.app.jpa.services.IVentasService;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentasContoller {
	
	@Autowired
	IVentasService ventasService;
	
	@GetMapping("/cliente({id}")
	public List<VentaListDTO> ventasPorCliente(@PathVariable(name = "id")Long id){
		return ventasService.findByCiente(id);
	}
	
	//@Autowired
	//IService<VentaListDTO,VentaDTO> ventasService;
	
	@PostMapping
	public Map<String,String>guardar(@RequestBody VentaDTO v){
		
		ventasService.guardar(v);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Venta guardado correctamentw");
		
		return respuesta;
	}
	
	@GetMapping
	public List<VentaListDTO>listar(){
		return ventasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public VentaListDTO obtnerPorId(@PathVariable(name = "id")Long id) {
		Optional<VentaListDTO> venta = ventasService.getById(id);
		if(venta.isPresent()) {
			return venta.get();
		}
		return null;
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id")Long id){
		ventasService.eliminar(id);
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg", "Venta eliminadao correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String,String>actualizar(@RequestBody VentaDTO v,@PathVariable(name = "id") Long id){
		Optional<VentaListDTO> venta = ventasService.getById(id);
		if(venta.isPresent()) {
			v.setId(id);
			ventasService.guardar(v);
		}
		else {
			throw new RuntimeException("El client no existe en la bd");
		}
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg", "Venta actualizada correctamente");
		return respuesta;
	}
}
