package com.romero.app.jpa.dtos;

import com.romero.app.jpa.Enums.TipoPokemon;

import java.util.List;

public class PokemonDtos {
    private Long id;
    private String nombre;
    private TipoPokemon tipoPrimario;
    private TipoPokemon tipoSecundario;
    private Float altura;
    private Float peso;
    private String descripcion;
    private Long estadisticas;
    private Long habilidad;
    private List<Long> movimientos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoPokemon getTipoPrimario() {
        return tipoPrimario;
    }

    public void setTipoPrimario(TipoPokemon tipoPrimario) {
        this.tipoPrimario = tipoPrimario;
    }

    public TipoPokemon getTipoSecundario() {
        return tipoSecundario;
    }

    public void setTipoSecundario(TipoPokemon tipoSecundario) {
        this.tipoSecundario = tipoSecundario;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Long estadisticas) {
        this.estadisticas = estadisticas;
    }

    public Long getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Long habilidad) {
        this.habilidad = habilidad;
    }

    public List<Long> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Long> movimientos) {
        this.movimientos = movimientos;
    }
}
