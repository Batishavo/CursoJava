package Actividad_Usuario_Edificio;
import java.util.ArrayList;
import java.util.List;
public class Alumno {
    //Aributos (variables) - > caracteristicas
    private String nombre;
    private Integer edad;
    private String matricula;
    private Integer numDeSalon;
    private String nombreDeEdificio;
    private Integer Calificacion;

    //metodos (funciones) -> acciones
    public void HacerExamen(String nombreAlumno, String nombreProfesor ){
        System.out.println("Soy el alumno" + nombreAlumno+ " y estoy haciendo el examen del profesor " + nombreProfesor);
    }
    //contructor


    public Alumno(){

        nombre="";
        edad=0;
        matricula="";
        numDeSalon=0;
        nombreDeEdificio="";
        Calificacion=0;

    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public Integer getNumDeSalon() {
        return numDeSalon;
    }

    public String getNombreDeEdificio() {
        return nombreDeEdificio;
    }

    public Integer getCalificacion() {
        return Calificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNumDeSalon(Integer numDeSalon) {
        this.numDeSalon = numDeSalon;
    }

    public void setNombreDeEdificio(String nombreDeEdificio) {
        this.nombreDeEdificio = nombreDeEdificio;
    }

    public void setCalificacion(Integer calificacion) {
        Calificacion = calificacion;
    }
}
