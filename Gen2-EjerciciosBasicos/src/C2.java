import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        double total=0.0;

        System.out.println("Introdusca los 5 articulos");

        for(int i=0;i<5;i++){
            double precioActual = lector.nextFloat();
            total +=precioActual;
        }
        System.out.println("El precio total es de "+(total*1.16));
    }
}
