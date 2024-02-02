import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class C1 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        Scanner lectorCadena = new Scanner(System.in);

        int opcion = 0;

        while(opcion!=5){
            System.out.println("Escoge una opcion\n" +
                    "1 - Lista de 10 numero aleatoriros\n" +
                    "2 -  funcion que recibe como parametro una lista de numeros enteros\n" +
                    "y regrese dos listas, una con los numeros pares y otra con los impares\n" +
                    "3 -  funcion que recibe como argumento un correo (String) y regrese\n" +
                    "como respuesta un \"OK\" si el correo es un correo valido o un \"ERROR\"\n" +
                    "si el correo no es un correo valido\n" +
                    "4 - funcion que recibe como argumento un arreglo de string\n" +
                    "una vez recibido el arreglo, la funcion debe crear un archivo txt\n" +
                    "llamado cadenas.txt ,en alguna carpeta de tu computadora\n" +
                    " en dicho archivo txt, cada renglon debera ser una cadena del arreglo\n" +
                    "5 - Cierre el progrma"
            );
            opcion = lector.nextInt();
            switch (opcion){
                case 1:
                    System.out.println(numerosAleatorios());
                    break;
                case 2:
                    System.out.println("Ingresa el total de numeroe");
                    int n = lector.nextInt();
                    System.out.println("Ingrese los numero");
                    List<Integer> numeros = new ArrayList<>();
                    for(int i=0;i<n;i++){
                        numeros.add(lector.nextInt());
                    }
                    System.out.println(numerosParesEImpares(numeros));
                    break;
                case 3:
                    System.out.println("Introduca el correo");
                    String correo = lectorCadena.nextLine();
                    System.out.println(esUnCorreo(correo));
                    break;
                case 4:
                    System.out.println("Introduca el tamño del arreglo");
                    int totalCadenas = lector.nextInt();
                    String arregloCadenas[] = new String[totalCadenas+10];
                    for(int i=0;i<totalCadenas;i++){
                        arregloCadenas[i]=lectorCadena.nextLine();
                    }
                    guardarCadena(arregloCadenas);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Coloque una opcion valida");
                    break;
            }
        }

    }

    public static List<Integer> numerosAleatorios(){

        int totalNumeros = 10;
        List<Integer> resultado = new ArrayList<>();
        // Crear un objeto de la clase Random
        Random rand = new Random();

        for(int i = 0;i<totalNumeros;i++){
            // Generar un número aleatorio entre 0 y 999
            int numeroAleatorio = rand.nextInt(1000);

            resultado.add(numeroAleatorio);
        }


        return resultado;

    }

    public  static List<List<Integer>> numerosParesEImpares(List<Integer>valores){
        List<List<Integer>> numeros = new ArrayList<>();
        numeros.add(new ArrayList<Integer>());
        numeros.add(new ArrayList<Integer>());
        int n = valores.size();

        for(int i=0;i<n;i++){
            if(valores.get(i)%2 == 0){
                numeros.get(1).add(valores.get(i));
            }
            else{
                numeros.get(0).add(valores.get(i));
            }
        }
        return numeros;
    }

    public static String esUnCorreo(String correo){
        String expresionRegular = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches()?"OK":"ERROR";
    }

    public static void guardarCadena(String arregloCadenas[]){
        int n = arregloCadenas.length;
        //Ruta a cambiar para validar
        String rutaArchivo = "C:\\Users\\TRDell09\\Documents\\archivo.txt";
        try {
            // Crear un objeto FileWriter para escribir en el archivo
            FileWriter fileWriter = new FileWriter(rutaArchivo);

            // Crear un objeto BufferedWriter para escribir en el archivo de manera eficiente
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir en el archivo
            for(int i = 0; i < n; i++) {
                if (arregloCadenas[i] != null) {
                    bufferedWriter.write(arregloCadenas[i]);
                    bufferedWriter.newLine(); // Agregar una nueva línea
                }
            }

            // Cerrar el BufferedWriter (esto también cerrará el FileWriter)
            bufferedWriter.close();

            System.out.println("Se ha escrito en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
}
