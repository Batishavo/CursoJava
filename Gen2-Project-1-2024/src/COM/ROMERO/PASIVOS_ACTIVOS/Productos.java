package COM.ROMERO.PASIVOS_ACTIVOS;

public class Productos {
    private String nombre;
    private double precio;
    private int cantidad;
    private float tasaImpuestos;

    // Constructor
    public Productos(String nombre, double precio, int cantidad,float tasaImpuestos) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tasaImpuestos = tasaImpuestos;
    }
    // Métodos para obtener y establecer los valores de los atributos
    public String getNombre() {
        return nombre;
    }

    public float getTasaImpuestos() {
        return tasaImpuestos;
    }

    public void setTasaImpuestos(float tasaImpuestos) {
        this.tasaImpuestos = tasaImpuestos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para calcular el valor total del producto (precio por cantidad)
    public double calcularValorTotal() {
        return precio * cantidad;
    }


}
