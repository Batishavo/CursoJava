package Actividad_Usuario_Edificio;

public class profesor {
    //Tiene atributos (variables) -> Caracteristicas

    private String nombre;
    private String numTrabajador;
    private Integer edad;
    private Integer numDeSalon;
    private String nombreDeEdificio;
    public void calificarExamen(String nombre, Integer calificacion){
        System.out.println("soy El profe " + this.nombre + "y estoy Calificando a " + nombre );
        System.out.println("Sucalificación es " + calificacion );
    }

    //Contructor
    profesor(){
        nombre= "";
        numTrabajador="";
        edad=0;
        numDeSalon=0;
        nombreDeEdificio="";
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumTrabajador() {
        return numTrabajador;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getNumDeSalon() {
        return numDeSalon;
    }

    public String getNombreDeEdificio() {
        return nombreDeEdificio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumTrabajador(String numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setNumDeSalon(Integer numDeSalon) {
        this.numDeSalon = numDeSalon;
    }

    public void setNombreDeEdificio(String nombreDeEdificio) {
        this.nombreDeEdificio = nombreDeEdificio;
    }
}
