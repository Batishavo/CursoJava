package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IAlumnoDao;
import com.romero.app.jpa.models.Alumno;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AlumnoService implements IService<Alumno,Alumno> {

    @Autowired
    private IAlumnoDao alumnoDao;

    @Override
    public List<Alumno> listar() {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos = (List<Alumno>) alumnoDao.findAll();
        return  alumnos;
    }

    @Override
    public Optional<Alumno> getById(Long id) {
        Optional<Alumno>alumno = alumnoDao.findById(id);
        return alumno;
    }

    @Override
    public void guardar(Alumno t) {
        this.alumnoDao.save(t);
    }

    @Override
    public void eliminar(Long id) {
        this.alumnoDao.deleteById(id);
    }
}
