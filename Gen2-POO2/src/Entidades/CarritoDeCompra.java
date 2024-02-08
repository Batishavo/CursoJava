package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompra {
    //Tinene atributos (variables) -> Caracteristicas

    Float ancho;
    Float alto;
    Float profundidad;
    String material;
    Integer numRuedas;
    String tipo;
    List<Producto> productos;

    void agregarProducto(Producto p){
        productos.add(p);
        System.out.println("Producto agregado al carrito...");

    }
    CarritoDeCompra(){
        productos = new ArrayList<>();

    }

    public Float getAncho() {
        return ancho;
    }

    public Float getAlto() {
        return alto;
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public String getMaterial() {
        return material;
    }

    public Integer getNumRuedas() {
        return numRuedas;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setAncho(Float ancho) {
        this.ancho = ancho;
    }

    public void setAlto(Float alto) {
        this.alto = alto;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setNumRuedas(Integer numRuedas) {
        this.numRuedas = numRuedas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
