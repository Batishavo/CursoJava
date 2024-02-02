import java.util.Scanner;

public class C5 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        System.out.println("Introduce los 25 valores");

        int numeroMayor =lector.nextInt();
        int numeroMenor = numeroMayor;
        double promedio = numeroMayor;

        for(int i=0;i<24;i++){

            int numeroActual = lector.nextInt();

            if(numeroActual>numeroMayor){
                numeroMayor = numeroActual;
            }
            if(numeroActual<numeroActual){
                numeroMenor = numeroActual;
            }

            promedio += numeroActual;

        }

        System.out.println(
                "El numero mayor es: "+numeroMayor+"\n"+
                        "El numero menor es: "+numeroMenor+"\n"+
                        "El promedio es: "+promedio/25.0
        );
    }
}
