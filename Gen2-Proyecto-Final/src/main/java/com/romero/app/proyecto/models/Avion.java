package com.romero.app.proyecto.models;

import com.romero.app.proyecto.utils.enums.TipoAvion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "avion")
@Entity
public class Avion {
    @Column(name = "codigo")
    @Id
    private String codigo;

    @Column(name = "tipo_avion")
    private TipoAvion tipoAvion;

    @Column(name = "horas_acumuladas")
    private Float horasAcumuladas;

    @Column(name = "capacidad")
    private Float capacidad;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoAvion getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(TipoAvion tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public Float getHorasAcumuladas() {
        return horasAcumuladas;
    }

    public void setHorasAcumuladas(Float horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    public Float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }
}
