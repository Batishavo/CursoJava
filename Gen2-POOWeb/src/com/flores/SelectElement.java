package com.flores;

import java.util.ArrayList;
import java.util.List;

public class SelectElement extends ElementoBase{
    //atributos / caracteristicas
    private List<OptionElement> opciones;

    @Override
    public String pintar() {
        StringBuilder sb=new StringBuilder("<select");
        sb.append("name='")
                .append(this.nombre)
                .append("'>");
        for (OptionElement opcion:this.opciones){
            sb.append("\n <option value=")
                    .append(opcion.getValor());

            sb.append(">")
                    .append(opcion.getDisplay())
                    .append("</option");
        }
        sb.append("</select>");
        return sb.toString();
    }
    //metodos / funciones de que permite agregar un elemento a la lista

    public void addOpcion(OptionElement opcion){
        this.opciones.add(opcion);
    }
//constructores
    public SelectElement(String valor, String nombre, String id){
        super(valor, nombre, id);
        opciones=new ArrayList<>();
    }

    //get and set
    public List<OptionElement> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OptionElement> opciones) {
        this.opciones = opciones;
    }
}
