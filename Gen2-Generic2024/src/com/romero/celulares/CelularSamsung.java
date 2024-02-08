package com.romero.celulares;

import com.romero.enums.Color;

public class CelularSamsung {
    //Atributos
    private String modelo;
    private String imei;
    private Float memoriaRam;
    private Float memoriaRom;
    private boolean botonSilecioEstado;
    private Float copaciadBateria;
    private Color color;

    //Metodos
    public void enviarMensaje(String mensaje){
        System.out.println("enviado el mensaje: "+ mensaje);
    }
    public boolean isBotonSilecioEstado() {
        return botonSilecioEstado;
    }
    //Contructor

    //Getters ans seters
    public Color getColor() {
        return color;
    }

    public Float getCopaciadBateria() {
        return copaciadBateria;
    }

    public String getModelo() {
        return modelo;
    }

    public String getImei() {
        return imei;
    }

    public Float getMemoriaRam() {
        return memoriaRam;
    }

    public Float getMemoriaRom() {
        return memoriaRom;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setMemoriaRam(Float memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public void setMemoriaRom(Float memoriaRom) {
        this.memoriaRom = memoriaRom;
    }

    public void setBotonSilecioEstado(boolean botonSilecioEstado) {
        this.botonSilecioEstado = botonSilecioEstado;
    }

    public void setCopaciadBateria(Float copaciadBateria) {
        this.copaciadBateria = copaciadBateria;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
