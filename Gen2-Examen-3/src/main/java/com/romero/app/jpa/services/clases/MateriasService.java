package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IMateriaDao;
import com.romero.app.jpa.models.Materia;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MateriasService implements IService<Materia,Materia> {

    @Autowired
    private IMateriaDao materiaDao;

    @Override
    public List<Materia> listar() {
        List<Materia> materias = new ArrayList<>();
        materias = (List<Materia>) materiaDao.findAll();
        return  materias;
    }

    @Override
    public Optional<Materia> getById(Long id) {
       Optional<Materia> materia = materiaDao.findById(id);
       return materia;
    }

    @Override
    public void guardar(Materia t) {
        this.materiaDao.save(t);
    }

    @Override
    public void eliminar(Long id) {
        this.materiaDao.deleteById(id);
    }
}
