package com.romero.app.jpa.services;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import com.romero.app.jpa.enums.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.romero.app.jpa.dao.IProductoDatos;
import com.romero.app.jpa.models.Producto;

@Component
public class ProductoService implements IService<Producto , Producto>{

	@Autowired
	private IProductoDatos productosDao;

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		List<Producto> productos = new ArrayList<>();
		productos = (List<Producto>) productosDao.findAll();
		return productos;
	}

	@Override
	public Optional<Producto> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Producto>producto = productosDao.findById(id);
		return producto;
	}

	@Override
	public void guardar(Producto t) {
		// TODO Auto-generated method stub
		this.productosDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.productosDao.deleteById(id);
	}

}
