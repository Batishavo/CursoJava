package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IHabilidadesDao;
import com.romero.app.jpa.models.Habilidad;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HabilidadService implements IService<Habilidad> {

    @Autowired
    private IHabilidadesDao habilidadesDao;

    @Override
    public List<Habilidad> listar() {
        List<Habilidad> habilidades = new ArrayList<>();
        habilidades = (List<Habilidad>) habilidadesDao.findAll();
        return habilidades;
    }

    @Override
    public Optional<Habilidad> getById(Long id) {
        Optional<Habilidad> habilidad = habilidadesDao.findById(id);
        return habilidad;
    }

    @Override
    public void guardar(Habilidad habilidad) {
        this.habilidadesDao.save(habilidad);
    }

    @Override
    public void eliminar(Long id) {
        this.habilidadesDao.deleteById(id);
    }
}
