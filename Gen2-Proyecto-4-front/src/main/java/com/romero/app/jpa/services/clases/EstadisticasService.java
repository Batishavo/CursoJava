//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IEstadisticasDao;
import com.romero.app.jpa.models.Estadisticas;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadisticasService implements IService<Estadisticas> {
    @Autowired
    private IEstadisticasDao estadisticasBaseDao;

    public EstadisticasService() {
    }

    public List<Estadisticas> listar() {
        new ArrayList();
        List<Estadisticas> estadisticas = (List)this.estadisticasBaseDao.findAll();
        return estadisticas;
    }

    public Optional<Estadisticas> getById(Long id) {
        Optional<Estadisticas> estadisticas = this.estadisticasBaseDao.findById(id);
        return estadisticas;
    }

    public void guardar(Estadisticas estadisticas) {
        this.estadisticasBaseDao.save(estadisticas);
    }

    public void eliminar(Long id) {
        this.estadisticasBaseDao.deleteById(id);
    }
}
