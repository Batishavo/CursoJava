package Entidades;
public class Producto {
    //atributos
    private String nombre;
    private String descripcion;
    private String marca;
    private Double precio;
    private String codigo;
    private Float capacidad;
    private String medida;
    private Boolean disponible;
    //metodos (funciones) ->acciones

    Producto(){

    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public Float getCapacidad() {
        return capacidad;
    }

    public String getMedida() {
        return medida;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
