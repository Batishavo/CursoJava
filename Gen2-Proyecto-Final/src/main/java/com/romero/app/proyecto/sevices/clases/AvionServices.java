package com.romero.app.proyecto.sevices.clases;

import com.romero.app.proyecto.dao.IAvionDAO;
import com.romero.app.proyecto.models.Avion;
import com.romero.app.proyecto.sevices.interfaces.IService;
import com.romero.app.proyecto.utils.enums.TipoAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Component
public class AvionServices implements IService<Avion,String> {

    @Autowired
    private IAvionDAO avionDAO;

    @Override
    public List<Avion> listar() {
        return (List)this.avionDAO.findAll();
    }

    @Override
    public Optional<Avion> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Avion avion) {
        this.avionDAO.save(avion);
    }

    @Override
    public void eliminar( String id) {
        this.avionDAO.deleteById(id);
    }

    public static List<TipoAvion> tiposDeAvion(){
        return new ArrayList<TipoAvion>(EnumSet.allOf(TipoAvion.class));
    }
}
