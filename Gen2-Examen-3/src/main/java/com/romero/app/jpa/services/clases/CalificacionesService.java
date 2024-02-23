package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.dao.IAlumnoDao;
import com.romero.app.jpa.dao.ICalificacionDao;
import com.romero.app.jpa.dao.IMateriaDao;
import com.romero.app.jpa.dtos.CalificaionesDTO;
import com.romero.app.jpa.models.Calificacion;
import com.romero.app.jpa.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CalificacionesService implements IService<Calificacion, CalificaionesDTO> {

    @Autowired
    private IAlumnoDao alumnoDao;
    @Autowired
    private IMateriaDao materiaDao;
    @Autowired
    private ICalificacionDao calificacionDao;


    @Override
    public List<Calificacion> listar() {
        List<Calificacion> calificaciones = new ArrayList<>();
        calificaciones = (List<Calificacion>) calificacionDao.findAll();
        return calificaciones;
    }

    @Override
    public Optional<Calificacion> getById(Long id) {
        Optional<Calificacion> calificacion = calificacionDao.findById(id);
        return calificacion;
    }

    @Override
    public void guardar(CalificaionesDTO t) {
        this.calificacionDao.save(dtoToObject(t));
    }

    /*public void guardar(Calificacion t) {
        this.calificacionDao.save(t);
    }*/

    @Override
    public void eliminar(Long id) {
        this.calificacionDao.deleteById(id);
    }

    public Calificacion dtoToObject(CalificaionesDTO calificaionesDTO){

        Calificacion calificacion = new Calificacion();

        calificacion.setId(calificaionesDTO.getId());
        calificacion.setMateria(materiaDao.findById(calificaionesDTO.getMaterria()).get());
        calificacion.setAlumno(alumnoDao.findById(calificaionesDTO.getAlumno()).get());
        calificacion.setCalificacion(calificaionesDTO.getCalificacion());
        calificacion.setFechaRegistro(calificaionesDTO.getFechaRegistro());

        return calificacion;

    }


}
