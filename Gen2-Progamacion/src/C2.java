import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        int n1;
        int n2;
        int suma;
        int resta;
        int multiplicadion;
        double division;

        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa el primer numero");
        n1 = s.nextInt();

        System.out.println("ingresa el segundo numero");
        n2 = s.nextInt();

        suma = n1+n2;
        resta = n1-n2;
        multiplicadion = n1*n2;
        division = n1/(n2*1.0);

        System.out.println("La suma es: "+suma);
        System.out.println("La resta es: "+resta);
        System.out.println("La multiplicacion es: " + multiplicadion);
        System.out.println("La divicion es: "+division);
    }
}
