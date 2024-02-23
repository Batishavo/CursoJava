package com.romero.app.jpa.dao;

import com.romero.app.jpa.models.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoDao extends CrudRepository <Alumno,Long> {
}
