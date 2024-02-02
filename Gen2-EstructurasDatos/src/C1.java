import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        //Programa que solicite 5 numero enteros y muestre la suma de los numeros
        //Declaracion de variables

        //Declaracion de de una variable tipo arreglo de enteros
        int numeros [];

        //inicialisacion de una varible tipo arrelog de enteros
        numeros = new int[20];
        //Variable especial
        Scanner s = new Scanner(System.in);

        int suma;
        int sum = 0;

        for(int i=0;i<5;i++){
            System.out.println("ingresa el dato:");
            numeros[i] = s.nextInt();

            sum += numeros[i];
        }


        /*ystem.out.println("ingresa el dato:");
        numeros[1] = s.nextInt();

        System.out.println("ingresa el dato:");
        numeros[2] = s.nextInt();

        System.out.println("ingresa el dato:");
        numeros[3] = s.nextInt();

        System.out.println("ingresa el dato:");
        numeros[4] = s.nextInt();

        suma = numeros[0]+numeros[1]+numeros[2]+numeros[3]+numeros[4];*/
        System.out.println(sum);


    }
}
/*[
        [
                [1,2,3],
                [6],
                []
        ],
        [],
        []
]*/
