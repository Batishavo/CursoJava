package com.romero.app.jpa.models.consultas;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaPromerdio {
    private List<ConsultasCalificacion> consultasCalificacionList;
    private Float promedio;

    public ConsultaPromerdio(List <ConsultasCalificacion> consulta){

        float promerdio = 0f;

        List <ConsultasCalificacion> consultaf = new ArrayList<>();
        SimpleDateFormat sdfDeseado = new SimpleDateFormat("dd/MM/yyyy");
        List<Date> fechasdfDeseado = new ArrayList<>();

        for(ConsultasCalificacion c : consulta){

            promerdio += c.getCalificacion_materia();

        }

        this.promedio = promerdio / (float) consulta.size();
        this.consultasCalificacionList = consulta;
    }

    public List<ConsultasCalificacion> getVistaCalificacionList() {
        return consultasCalificacionList;
    }

    public void setVistaCalificacionList(List<ConsultasCalificacion> consultasCalificacionList) {
        this.consultasCalificacionList = consultasCalificacionList;
    }

    public Float getPromedio() {
        return promedio;
    }

    public void setPromedio(Float promedio) {
        this.promedio = promedio;
    }
}
