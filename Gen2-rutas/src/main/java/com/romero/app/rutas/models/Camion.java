package com.romero.app.rutas.models;

public class Camion {
    private Long id;
    private String matricula;
    private String tipoCamion;

    private String marca;
    private Long modelo;
    private Integer capacidad;
    private  Float kilometraje;
    private Boolean disponibilidad;

    public Camion(){

    }
    public Camion(Long id,String matricula, String tipoCamion, String marca, Long modelo, Integer capacidad, Float kilometraje, Boolean disponibilidad) {
        this.id = 0L;
        this.matricula = matricula;
        this.tipoCamion = tipoCamion;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.kilometraje = kilometraje;
        this.disponibilidad = disponibilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getModelo() {
        return modelo;
    }

    public void setModelo(Long modelo) {
        this.modelo = modelo;
    }
}
