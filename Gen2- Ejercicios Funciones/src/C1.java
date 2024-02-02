import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        Scanner lectorCadena = new Scanner(System.in);

        int opcion = 0;

        while(opcion!=9){
            System.out.println("Menu \n" +
                    "1) Agregar elemento a la lista\n" +
                    "2) Eliminar elemento de la lista\n" +
                    "3) suma\n" +
                    "4) Promedio\n" +
                    "5) Maximo\n" +
                    "6) Minimo\n" +
                    "7) Contar\n" +
                    "8) Concatenar\n" +
                    "9 ) Salir"
            );

            opcion = lector.nextInt();

            switch (opcion){
                case 1:

                    List<Integer>listaAgregar = new ArrayList<>();
                    int tamanoListaAgregar;
                    System.out.println("Introduce el tamaño de la lista");

                    tamanoListaAgregar = lector.nextInt();

                    for(int i=0;i<tamanoListaAgregar;i++){
                        listaAgregar.add(lector.nextInt());
                    }

                    System.out.println("Introdusca valor a agregar");
                    int valorAAgregar = lector.nextInt();

                    agregarElemento(listaAgregar,valorAAgregar);
                    break;
                case 2:
                    List<Integer>listaEliminar = new ArrayList<>();
                    int tamanoListaEliminar;
                    System.out.println("Introduce el tamaño de la lista");

                    tamanoListaAgregar = lector.nextInt();

                    for(int i=0;i<tamanoListaAgregar;i++){
                        listaEliminar.add(lector.nextInt());
                    }

                    System.out.println("Introdusca valor a eliminar");
                    int numeroAEliminar = lector.nextInt();

                    eliminarElemento(listaEliminar,numeroAEliminar);
                    break;
                case 3:
                    List<Integer>listaSuma = new ArrayList<>();
                    int tamanoListaSuma;
                    System.out.println("Tamño de la lista");
                    tamanoListaSuma = lector.nextInt();
                    for(int i=0;i<tamanoListaSuma;i++){
                        listaSuma.add(lector.nextInt());
                    }
                    System.out.println(suma(listaSuma));
                    break;
                case 4:
                    List<Integer>listaPromedio = new ArrayList<>();
                    int tamanoListaPromedio;
                    System.out.println("Tamño de la lista");
                    tamanoListaPromedio = lector.nextInt();
                    for(int i=0;i<tamanoListaPromedio;i++){
                        listaPromedio.add(lector.nextInt());
                    }
                    System.out.println(promedio(listaPromedio));
                    break;
                case 5:
                    List<Integer>listaMayor = new ArrayList<>();
                    int tamanoListaMayor;
                    System.out.println("Tamño de la lista");
                    tamanoListaMayor = lector.nextInt();
                    for(int i=0;i<tamanoListaMayor;i++){
                        listaMayor.add(lector.nextInt());
                    }
                    System.out.println(mayor(listaMayor));
                    break;
                case 6:
                    List<Integer>listaMenor = new ArrayList<>();
                    int tamanoListaMenor;
                    System.out.println("Tamño de la lista");
                    tamanoListaMenor = lector.nextInt();
                    for(int i=0;i<tamanoListaMenor;i++){
                        listaMenor.add(lector.nextInt());
                    }
                    System.out.println(menor(listaMenor));
                    break;
                case 7:
                    List<Integer>listaContar = new ArrayList<>();
                    int tamanoListaContar;
                    System.out.println("Tamño de la lista");
                    tamanoListaContar = lector.nextInt();
                    for(int i=0;i<tamanoListaContar;i++){
                        listaContar.add(lector.nextInt());
                    }
                    System.out.println("Numero a buscar");
                    int numero=lector.nextInt();
                    System.out.println(contar(listaContar,numero));
                    break;
                case 8:
                    List<String>listaConcatenar = new ArrayList<>();
                    int tamanoListaConcatnar;
                    System.out.println("Tamño de la lista");
                    tamanoListaConcatnar = lector.nextInt();
                    for(int i=0;i<tamanoListaConcatnar;i++){
                        listaConcatenar.add(lectorCadena.nextLine());
                    }

                    System.out.println(concatenar(listaConcatenar));
                    break;
                case 9:
                    break;
                default:
                    break;
            }
        }

    }
    public  static void agregarElemento(List<Integer>ListaAgregar,int numeroAgregar){
        ListaAgregar.add(numeroAgregar);
        System.out.println(ListaAgregar);
    }

    public  static void eliminarElemento(List<Integer>ListaEliminar,int numeroAEliminar){
        ListaEliminar.remove(Integer.valueOf(numeroAEliminar));
        System.out.println(ListaEliminar);
    }

    public  static  int suma(List<Integer>ListaSuma){
        int n = ListaSuma.size();
        int suma = 0;

        for(int i=0;i<n;i++){
            suma+=ListaSuma.get(i);
        }

        return suma;

    }
    public  static  double promedio(List<Integer>listaPromedio){
        int n = listaPromedio.size();
        int suma = 0;

        for(int i=0;i<n;i++){
            suma+=listaPromedio.get(i);
        }

        return (double)suma/(double)n;

    }

    public  static  int mayor(List<Integer>listaMayor){
        int mayor = listaMayor.get(0);
        for(int i=1;i<listaMayor.size();i++){
            mayor=Math.max(mayor,listaMayor.get(i));
        }
        return mayor;
    }

    public  static  int menor(List<Integer>listaMenor){
        int menor = listaMenor.get(0);
        for(int i=1;i<listaMenor.size();i++){
            menor=Math.min(menor,listaMenor.get(i));
        }
        return menor;
    }
    public  static  int contar(List<Integer>listaContar,int num){
        int contador = 0;
        for(int i=0;i<listaContar.size();i++){
            if(num==listaContar.get(i)){
                contador++;
            }
        }
        return contador;
    }

    public static String concatenar(List<String>listaConcatenar){
        String cadena = "";
        for(int i=0;i<listaConcatenar.size();i++){
            cadena+=listaConcatenar.get(i);
        }
        return cadena;
    }
}
