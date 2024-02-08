package com.flores;

public abstract class ElementoBase {
    //atributos/caracteristicas(variables)
    protected String valor;
    protected String nombre;
    protected String id;
    //funciones/metodos/acciones
    public abstract String pintar();

    //contructures
    public ElementoBase(){

    }
    public ElementoBase(String valor, String nombre, String id){
        this.valor=valor;
        this.nombre=nombre;
        this.id=id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
