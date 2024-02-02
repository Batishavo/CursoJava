import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        System.out.println("Introdusca X en cm");
        int x = lector.nextInt();
        System.out.println("Introdusca D en cm");
        int D = lector.nextInt();
        System.out.println("Introdusca d en cm");
        int d = lector.nextInt();

        double volumen = (double)d*(double)D*20.0/2.0;


        System.out.println("El resultado "+volumen);

    }

    public static class C6 {
        public static void main(String[] args) {

            Scanner lector = new Scanner(System.in);

            double subtotal = 0.0;
            double iva = 0.0;
            double descuento = 0.0;

            System.out.println("Coloque los 5 articulos");

            for(int i=0;i<5;i++){
                double articuloActual = lector.nextDouble();

                subtotal+=articuloActual;
            }

            iva = subtotal*0.16;
            descuento = (subtotal+1.16)*0.10;


            if(subtotal*1.16>=2000.0){
                System.out.println(
                        "subtotal :"+subtotal+"\n"+
                        "iva :"+iva+"\n"+
                        "Descuento :"+descuento+"\n"+
                        "Total a pagar: "+((subtotal*1.16)-descuento)

                );
            }
            else{
                System.out.println(
                        "subtotal :"+subtotal+"\n"+
                        "iva :"+iva+"\n"+
                        "Total a pagar: "+subtotal*1.16

                );
            }

        }
    }
}
