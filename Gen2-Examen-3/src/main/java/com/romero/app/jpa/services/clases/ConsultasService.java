package com.romero.app.jpa.services.clases;

import com.romero.app.jpa.models.consultas.ConsultasCalificacion;
import com.romero.app.jpa.repository.ConsultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultasService {

    private ConsultasRepository consultasRepository;

    public List<ConsultasCalificacion> consultasCalificacion(Long id){

        consultasRepository = new ConsultasRepository();
        List<ConsultasCalificacion> consultasCalificacions = new ArrayList<>();
        consultasCalificacions = consultasRepository.calificacionesPor(id);
        return consultasCalificacions;
    }
}
