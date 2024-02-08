package COM.ROMERO.PASIVOS_ACTIVOS;

public class Propiedades {
    private String direccion;
    private double tamaño;
    private int numeroHabitaciones;
    private double precio;

    // Constructor
    public Propiedades(String direccion, double tamaño, int numeroHabitaciones, double precio) {
        this.direccion = direccion;
        this.tamaño = tamaño;
        this.numeroHabitaciones = numeroHabitaciones;
        this.precio = precio;
    }

    // Métodos para obtener y establecer los valores de los atributos
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
