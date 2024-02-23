package com.romero.app.proyecto.sevices.clases;

import com.romero.app.proyecto.dao.IVueloDAO;
import com.romero.app.proyecto.models.Vuelo;
import com.romero.app.proyecto.sevices.interfaces.IService;
import com.romero.app.proyecto.utils.enums.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VueloServices implements IService<Vuelo,Long> {

    @Autowired
    private IVueloDAO vueloDAO;

    @Override
    public List<Vuelo> listar() {
        return (List)this.vueloDAO.findAll();
    }

    @Override
    public Optional<Vuelo> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Vuelo vuelo) {
        this.vueloDAO.save(vuelo);
    }

    @Override
    public void eliminar(Long id) {

    }
    public List<Vuelo> listarPorEstado(Estado estado) {
        return (List)this.vueloDAO.findByEstado(estado);
    }

}
