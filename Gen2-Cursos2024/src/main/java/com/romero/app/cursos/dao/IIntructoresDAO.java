package com.romero.app.cursos.dao;

import org.springframework.data.repository.CrudRepository;

import com.romero.app.cursos.models.Instructor;

public interface IIntructoresDAO extends CrudRepository<Instructor, Long> {

}
