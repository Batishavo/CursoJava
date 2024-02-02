import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        Scanner lectorCadena = new Scanner(System.in);
        int opcion = 0;

        List<String> categorias = new ArrayList<String>();
        List<List<String>> productos = new ArrayList<>();

        while(opcion!=5){

            System.out.println(
                    "1) Mostrar Categorias\n" +
                            "2) Mostrar Productos por categoria\n" +
                            "3) Agregar Categoria\n" +
                            "4) Agregar Producto a una categoria\n" +
                            "5) Salir"
            );
            opcion = lector.nextInt();
            switch (opcion){
                case 1:
                    for(int i=0;i<categorias.size();i++){
                        System.out.println(i+1+" "+categorias.get(i)+" ");
                    }
                    break;
                case 2:
                    System.out.println("Cual es la categoria que quieres consultar ??");
                    for(int i=0;i<categorias.size();i++){
                        System.out.println(i+1+" "+categorias.get(i)+" ");
                    }
                    int categoria = lector.nextInt()-1;
                    int totalProductos = productos.get(categoria).size();
                    for(int i=0;i<totalProductos;i++){
                        System.out.println(productos.get(categoria).get(i));
                    }

                    break;
                case 3:
                    System.out.println("Agrega la nueva categoria");
                    String nuevaCategoria = lectorCadena.next();
                    categorias.add(nuevaCategoria);
                    productos.add(new ArrayList<String>());
                    break;
                case 4:
                    System.out.println("A que categoria que quieres agregar??");
                    for(int i=0;i<categorias.size();i++){
                        System.out.println(i+1+" "+categorias.get(i)+" ");
                    }
                    int categoriaProducto = lector.nextInt()-1;
                    System.out.println("Nombre del producto");
                    String nombreDelProducto = lectorCadena.next();
                    productos.get(categoriaProducto).add(nombreDelProducto);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("coloque un numero valido");
                    break;
            }
        }
    }
}
