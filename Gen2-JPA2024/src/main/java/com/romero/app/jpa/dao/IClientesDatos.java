package com.romero.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.romero.app.jpa.models.Cliente;

public interface IClientesDatos extends CrudRepository<Cliente, Long> {

}
