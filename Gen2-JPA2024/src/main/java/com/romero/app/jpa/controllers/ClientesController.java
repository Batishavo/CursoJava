package com.romero.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.romero.app.jpa.services.IService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClientesController {
	//Attributes
	@Autowired
	@Qualifier("8ram")
	IService<Cliente,Cliente> clietesService;
	
	@PostMapping
	public Map<String,String>guardar(@RequestBody Cliente c){
		clietesService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Clientes guardado correctamnete");
		return respuesta;
	}
	
	@GetMapping
	public List<Cliente>listar(){
		return clietesService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Cliente obtnerPorId(@PathVariable(name = "id")Long id) {
		Optional<Cliente> cliente = clietesService.getById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id")Long id){
		clietesService.eliminar(id);
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg","Cliente eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String,String>actualizar(@RequestBody Cliente c,@PathVariable(name = "id") Long id){
		Optional<Cliente> cliente = clietesService.getById(id);
		if(cliente.isPresent()) {
			c.setId(id);
			clietesService.guardar(c);
		}
		else {
			throw new RuntimeException("El cliente no existe en la bd");
		}
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cliente actualizado correctamente");
		return respuesta;
	}
	
}
