public class Intructor {
    String nombre;
    String numTrabajador;
    float salario;
    Integer edad;
    String tecnologia;

    void explicar(String tema){
        System.out.println("Soy un intructor y estoy explicanod el tema de "+tema);
    }

    void asignarTrabajo(Alumno a){
        System.out.println("Asigne un trabajo al alumno "+a.nombre);
    }
}
