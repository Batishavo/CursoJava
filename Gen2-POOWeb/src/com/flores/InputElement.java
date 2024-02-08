package com.flores;

public class InputElement extends ElementoBase{
    //atributos / caracteristicas
    private String tipo;


    //metodo
    @Override
    public String pintar() {

        return null;
    }

    //contructores
    public InputElement(String valor, String nombre, String id){
        super(valor, nombre, id);
        this.tipo=tipo;
    }

    //get and set
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }

}
