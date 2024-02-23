package com.romero.app.proyecto.sevices.clases;

import com.romero.app.proyecto.dao.IPilotoDAO;
import com.romero.app.proyecto.models.Avion;
import com.romero.app.proyecto.models.Piloto;
import com.romero.app.proyecto.sevices.interfaces.IService;
import com.romero.app.proyecto.utils.enums.Sexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Component
public class PilotoServices implements IService<Piloto,String> {

    @Autowired
    private IPilotoDAO pilotoDAO;

    @Override
    public List<Piloto> listar() {

        return (List)this.pilotoDAO.findAll();
    }

    @Override
    public Optional<Piloto> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Piloto piloto) {
        this.pilotoDAO.save(piloto);
    }

    @Override
    public void eliminar(String id) {
        this.pilotoDAO.deleteById(id);
    }

    public static List<Sexo> sexos(){
        return new ArrayList<Sexo>(EnumSet.allOf(Sexo.class));
    }

}
