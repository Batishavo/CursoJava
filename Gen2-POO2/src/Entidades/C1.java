package Entidades;

public class C1 {
    public static void main(String[] args) {

        Producto p1 = new Producto();
        p1.setNombre("Fabuloso");
        p1.setDescripcion("Fabuloso del morado");
        p1.setCodigo("FL123");
        p1.setPrecio(23.0978);
        p1.setCapacidad(1f);
        p1.setMedida("Litros");
        p1.setMarca("J & J");
        p1.setDisponible(true);

        Producto p2 = new Producto();
        p2.setNombre("DETERGENTE");
        p2.setDescripcion("DETERGENTE DE ROPA DE COLOR");
        p2.setCodigo("DT123");
        p2.setPrecio(122.0978);
        p2.setCapacidad(1f);
        p2.setMedida("GRAMOS");
        p2.setMarca("ACE");
        p2.setDisponible(true);


        CarritoDeCompra carro = new CarritoDeCompra();
        carro.setAlto(12F);
        carro.setAncho(23F);
        carro.setProfundidad(34F);
        carro.setTipo("Carrito");
        carro.setMaterial("plastico");


        Cliente c1 = new Cliente();
        c1.setNombre("Javier");
        c1.setApMaterno("Torres");
        c1.setApPaterno("Timal");
        c1.setCorreo("javir@gmail.com");
        c1.setEdad(12);
        c1.setGenero('M');
        c1.setNumCliente("J123");
        c1.setCarrito(carro);

        c1.getCarrito().agregarProducto(p1);
        c1.getCarrito().agregarProducto(p1);
        c1.getCarrito().agregarProducto(p1);
        c1.getCarrito().agregarProducto(p2);
        c1.pagar();

    }
}
