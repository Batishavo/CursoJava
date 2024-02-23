package com.romero.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.romero.app.jpa.enums.Categorias;
import com.romero.app.jpa.services.CategoriasService;
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
import com.romero.app.jpa.models.Producto;
import com.romero.app.jpa.services.IService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
	@Autowired
	IService<Producto,Producto> productoService;
	@Autowired
	CategoriasService categoriasService;
	@GetMapping("/categorias")
	public List<Categorias>  getCatecorias(){
		return  categoriasService. getCategorias();
	}


	@PostMapping
	public Map<String,String>guardar(@RequestBody Producto p){
		productoService.guardar(p);
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg", "Producto guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Producto>listar(){
		return productoService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Producto obtnerPorId(@PathVariable(name = "id")Long id) {
		
		Optional<Producto> producto = productoService.getById(id);
		if(producto.isPresent()) {
			return producto.get();
		}
		
		return null;
	}
	
	@DeleteMapping("/eliminar")
	public Map<String,String> eliminar(@RequestParam(name = "id")Long id){
		productoService.eliminar(id);
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cliente elimiando correctamnete");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String,String>actualizar(@RequestBody Producto p,@PathVariable(name = "id") Long id){
		Optional<Producto> producto = productoService.getById(id);
		if(producto.isPresent()) {
			p.setId(id);
			productoService.guardar(p);
		}
		else {
			throw new RuntimeException("El client on existe en la bd");
		}
		Map<String,String> respuesta = new HashMap<>();
		respuesta.put("msg","Cliente actualizado corrctamente");
		return respuesta;
	}
	
}
