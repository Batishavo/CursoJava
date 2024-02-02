import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int totalNumero = 20;
        List<Integer> listasNumeros = new ArrayList<Integer>();
        int mayor = 0;
        int menor = 0;
        int suma = 0;

        for(int i = 0;i<totalNumero;i++){
            System.out.println("Ingrese un numero mayor a 0");
            int numeroActual = lector.nextInt();
            while(numeroActual<=0){
                System.out.println("Ingres un numero positivo mayor a 0");
                numeroActual = lector.nextInt();
            }
            listasNumeros.add(numeroActual);
        }

        mayor = menor = suma = listasNumeros.get(0);

        for(int i=1;i<totalNumero;i++){
            menor = Math.min(menor,listasNumeros.get(i));
            mayor = Math.max(mayor,listasNumeros.get(i));
            suma += listasNumeros.get(i);
        }

        System.out.println(
                "Mayor :"+mayor+"\n"+
                        "Menor :"+menor+ "\n"+
                        "Promedio :"+((float)suma/(float)totalNumero) +"\n"+
                        "Suma :"+suma+"\n"
        );

    }
}
