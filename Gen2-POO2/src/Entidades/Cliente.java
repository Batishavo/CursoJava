package Entidades;
public class Cliente {
    //atributos
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String correo;
    private String numCliente;
    private char genero;
    private Integer edad;
    private
    CarritoDeCompra carrito;

    //Metodos (funciones) -> Acciones

    void pagar(){
        System.out.println("pagando cuenta");
    }

    Cliente(){

    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumCliente() {
        return numCliente;
    }

    public char getGenero() {
        return genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public CarritoDeCompra getCarrito() {
        return carrito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setCarrito(CarritoDeCompra carrito) {
        this.carrito = carrito;
    }
}
