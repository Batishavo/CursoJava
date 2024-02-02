import java.util.List;
import java.util.ArrayList;

public class C2 {
    public static void main(String[] args) {
        List<Integer> listaEnteros = new ArrayList<Integer>();

        //agregamos 3 elementos a la lista
        listaEnteros.add(78);
        listaEnteros.add(45);
        listaEnteros.add(12);

        //mostramos los 3 elmentos de la lista, uno por uno
        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));
        System.out.println(listaEnteros.get(2));

        //eliminamos de la lista el numero 45 , que se encuetra en la posicion 1
        listaEnteros.remove(1);

        //despues de eliminar , las posociones del arreglo se recorren
        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));
    }
}

