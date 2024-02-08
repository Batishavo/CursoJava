package com.flores;

public class OptionElement {
    //atributos
    private String valor;
    private String display;
//funcion
    public OptionElement(String valor, String display){
        this.valor=valor;
        this.display=display;
    }
    //get and set

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
