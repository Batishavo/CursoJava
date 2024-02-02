import java.util.Scanner;

public class C4 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        System.out.println("Respuesta correctas");
        int respuestasCorrectas = lector.nextInt();
        System.out.println("Respuestas incorrectas");
        int respuestasIncorrectas = lector.nextInt();
        System.out.println("En blanco");
        int respuestasBlanco = lector.nextInt();
        System.out.println("Total = " +((respuestasCorrectas*4)-respuestasIncorrectas));
    }
}
