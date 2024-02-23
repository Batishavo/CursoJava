package com.romero.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.romero.app.jpa.dao.IClientesDatos;
import com.romero.app.jpa.models.Cliente;

@Component
@Qualifier("8ram")
public class ClientesService implements IService<Cliente,Cliente>{
	
	@Autowired
	private IClientesDatos clientesDao;
	
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<>();
		clientes = (List<Cliente>)clientesDao.findAll();
		return clientes;
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = clientesDao.findById(id);
		return cliente;
	}

	@Override
	public void guardar(Cliente t) {
		// TODO Auto-generated method stub
		this.clientesDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.clientesDao.deleteById(id);
	}

}
