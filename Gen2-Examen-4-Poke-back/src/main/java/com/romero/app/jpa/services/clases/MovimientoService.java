package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IMovimientosDao;
import com.romero.app.jpa.models.Movimiento;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovimientoService implements IService<Movimiento> {
    @Autowired
    private IMovimientosDao movimientosDao;

    public MovimientoService() {
    }

    public List<Movimiento> listar() {
        new ArrayList();
        List<Movimiento> movimientos = (List)this.movimientosDao.findAll();
        return movimientos;
    }

    public Optional<Movimiento> getById(Long id) {
        Optional<Movimiento> movimiento = this.movimientosDao.findById(id);
        return movimiento;
    }

    public void guardar(Movimiento movimiento) {
        this.movimientosDao.save(movimiento);
    }

    public void eliminar(Long id) {
        this.movimientosDao.deleteById(id);
    }
}