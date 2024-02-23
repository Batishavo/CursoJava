package com.romero.app.proyecto.models;

import com.romero.app.proyecto.utils.enums.Estado;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "vuelo")
@Entity
public class Vuelo {

    @Column(name ="id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VUELO_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_VUELO",allocationSize = 1,name = "VUELO_SEQ" )
    private Long id;

    @JoinColumn(name = "origen")
    @ManyToOne
    private AeroPuerto origen;

    @JoinColumn(name = "destino")
    @ManyToOne
    private AeroPuerto destino;

    @Column(name = "fecha_hora")
    private Timestamp fechaYhora;

    @JoinColumn(name = "piloto")
    @ManyToOne
    private Piloto piloto;

    @JoinColumn(name = "avion")
    @ManyToOne
    private Avion avion;

    @Column(name = "distancia")
    private Float distancia;

    @Column(name = "estado")
    private Estado estado;

    @Column(name = "codigo")
    private String codigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AeroPuerto getOrigen() {
        return origen;
    }

    public void setOrigen(AeroPuerto origen) {
        this.origen = origen;
    }

    public AeroPuerto getDestino() {
        return destino;
    }

    public void setDestino(AeroPuerto destino) {
        this.destino = destino;
    }

    public Timestamp getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(Timestamp fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
