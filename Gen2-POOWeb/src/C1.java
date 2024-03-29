import com.flores.*;

import java.util.ArrayList;
import java.util.List;

public class C1 {
    public static void main(String[] args) {

        //creamos dos objetos input
        InputElement input1 = new InputElement("javier", "nombre", "nombre");
        input1.setTipo("text");

        InputElement input2 = new InputElement("124", "contraseña", "contraseña");
        input2.setTipo("email");

        //creamos un objeto de tipo TextArea
        TextAreaElement texto = new TextAreaElement("soy javiere y me gusta la musica", "about", "about");
        texto.setFilas(10);
        texto.setColumnas(20);

        //creamos dos option para posteriormente agregar al select
        OptionElement opcion1 = new OptionElement("1", "java");
        OptionElement opcion2 = new OptionElement("2", "NET");

        //creamos el select para poder agregar los dos option creados anteriormente
        SelectElement select = new SelectElement("", "tecnologia", "tecnologia");
        select.addOpcion(opcion1);
        select.addOpcion(opcion2);

        List<ElementoBase> elementos = new ArrayList<>();
        elementos.add(input1);
        elementos.add(input2);
        elementos.add(texto);
        elementos.add(select);

        for (int i = 0; i <elementos.size(); i++) {
            System.out.println(elementos.get(i).pintar());
            
        }

    }
}


