package com.romero.app.jpa.dtos;

import java.util.Date;

public class CalificaionesDTO {
    private Long id;
    private Long materria;
    private Long alumno;
    private Float calificacion;

    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaterria() {
        return materria;
    }

    public void setMaterria(Long materria) {
        this.materria = materria;
    }

    public Long getAlumno() {
        return alumno;
    }

    public void setAlumno(Long alumno) {
        this.alumno = alumno;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
