package com.romero.app.jpa.models.consultas;


import java.util.Date;

public class ConsultasCalificacion {
    private Long id_t_usuario;
    private String nombre_alumno;
    private String apellido_paterno_alumno;
    private String nombre_materia;
    private Float calificacion_materia;
    private String fecha_registro;

    public Long getId_t_usuario() {
        return id_t_usuario;
    }

    public void setId_t_usuario(Long id_t_usuario) {
        this.id_t_usuario = id_t_usuario;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getApellido_paterno_alumno() {
        return apellido_paterno_alumno;
    }

    public void setApellido_paterno_alumno(String apellido_paterno_alumno) {
        this.apellido_paterno_alumno = apellido_paterno_alumno;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public Float getCalificacion_materia() {
        return calificacion_materia;
    }

    public void setCalificacion_materia(Float calificacion_materia) {
        this.calificacion_materia = calificacion_materia;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


}
