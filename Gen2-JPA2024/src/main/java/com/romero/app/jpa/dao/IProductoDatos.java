package com.romero.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;


import com.romero.app.jpa.models.Producto;

public interface IProductoDatos extends CrudRepository<Producto, Long> {

}
