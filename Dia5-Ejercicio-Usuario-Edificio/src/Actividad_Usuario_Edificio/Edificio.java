package Actividad_Usuario_Edificio;

public class Edificio {

    String nombreDeEdificio;
    Integer numDeSalon;

    public Edificio(){
        numDeSalon=0;
        nombreDeEdificio="";
    }

    public String getNombreDeEdificio() {
        return nombreDeEdificio;
    }

    public Integer getNumDeSalon() {
        return numDeSalon;
    }

    public void setNombreDeEdificio(String nombreDeEdificio) {
        this.nombreDeEdificio = nombreDeEdificio;
    }

    public void verificarEdificio(String nombre){
        if(nombre == nombreDeEdificio){
            System.out.println("Este si es tu edificio ya que el edificio se llama " + nombreDeEdificio+ " y tu perteneces a " + nombre);
        }
        else{
            System.out.println("Tu no perteneces a este edificio ya que este es " + nombreDeEdificio +" y tu buscas " + nombre);
        }

    }
    public void verificarNumDeSalon(Integer num){
        if(num == numDeSalon){
            System.out.println("Este si es tu salon ya que es el numero es " + numDeSalon+ " y tu perteneces al " + num);
        }else {
            System.out.println("Este no es tu salon ya que el numero es "+ numDeSalon+ " y tu perteneces al " +num);
        }
    }

    public void setNumDeSalon(Integer numDeSalon) {
        this.numDeSalon = numDeSalon;
    }
}
