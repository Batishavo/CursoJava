import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.*;

public class C1 {
    public static void main(String[] args) {
        //Definicion de una expresion lambda de tipo : CONSUMER
        //El CONSUME NO  regresa ningun valo de retorno
        Consumer<String> consumidor = (cadena)->{
            System.out.println(cadena.toUpperCase());
        };

        consumidor.accept("Hola mundo");

        BiConsumer<String,Integer>consumidor2 = (nombre,anio)->{
            SimpleDateFormat sfd = new SimpleDateFormat("yyyy");
            Integer edad = Integer.parseInt(sfd.format(new Date()))-anio;
            System.out.println(nombre + " tiene "+edad+" años!");
        };

        consumidor2.accept("Javier",1988);

        //Definicion de una expresion lamda de tipo : Supplier
        //El Supplier es capaz de retornar un valor de retorno
        Supplier<String> crearSaludo = ()->{
            return "Hola Javier como estas, que tal tu día";
        };
        //Consumir el supplier
        System.out.println(crearSaludo.get());;

        //Definicion de una expresion lambda de tipo: Function
        //Funcion es capaz de retorna un valor y aceptar parametros
        Function<String,String> cuentaCaracteres = (nombre)->{
            //sout(nombre.lenght());
            return nombre.length()+" ";
        };
        System.out.println("Hola");

        //Definicion de una expresion lambda de tipo: BiFunction
        BiFunction<String,Integer,String> saludar3 = (nombre,anio)->{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Integer edad = Integer.parseInt(sdf.format((new Date())))-anio;
            return nombre+" tiene "+edad+" años ";
        };

        System.out.println(saludar3.apply("Javier Torres Timal",1964));

        Predicate<Integer> prueba = (numero)->{
            return numero == 0;
        };

        System.out.println(prueba.test(2));





    }
}
