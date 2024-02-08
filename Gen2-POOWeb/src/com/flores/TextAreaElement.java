package com.flores;

public class TextAreaElement extends ElementoBase{
    //atributos
    private int filas;
    private int columnas;

    @Override
    public String pintar() {
        return "<textarea name= " + this.nombre + " cols="
                +this.columnas+" rows= "+this.filas+">"
                +this.valor+"</textarea>";
    }

    //constructor
    public TextAreaElement(String valor, String nombre, String id){
        super(valor, nombre, id);
    }
//get and set

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}
