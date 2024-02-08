import java.util.ArrayList;
import java.util.List;

public class Alumno {

    String nombre;
    String matricula;
    Integer edad;
    List<Integer> calificaines;
    String generacion;

    void tomarNota(String texto){
        System.out.println("soy el alumno "+nombre+" y estoy tomando nota del texto "+texto);
    }

    void entregarTarea(){
        System.out.println("Estoy estregando tarea");
    }
    void realizarPreguntas(String pregunta){
        System.out.println("Mi pregunta es: "+pregunta);
    }

    String contestarPregunta(){
        return "Mi respuesta a tu pregunta es ...";
    }

    Alumno(){
        nombre = "";
        edad = 0;
        matricula = "";
        generacion = "";
        calificaines = new ArrayList<>();
    }

}
