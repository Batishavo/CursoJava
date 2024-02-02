import java.util.Scanner;

public class C7 {


    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double subtotal = 0.0;
        double iva = 0.0;
        double descuento = 0.0;
        System.out.println("Coloque los 5 articulos");

        for(int i = 0; i < 5; ++i) {
            double articuloActual = lector.nextDouble();
            subtotal += articuloActual;
        }

        iva = subtotal * 0.16;
        descuento = (subtotal + 1.16) * 0.1;
        if (subtotal * 1.16 >= 2000.0) {
            System.out.println("subtotal :" + subtotal + "\n" + "iva :" + iva + "\n" + "Descuento :" + descuento + "\n" + "Total a pagar: " + (subtotal * 1.16 - descuento));
        } else {
            System.out.println("subtotal :" + subtotal + "\n" + "iva :" + iva + "\n" + "Total a pagar: " + subtotal * 1.16);
        }

    }
}
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

