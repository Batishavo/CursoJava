import java.util.Scanner;

public class C1 {

    public static void main(String[] args) {

        int numeroAlumnos ;
        double promedio = 0;

        Scanner lector = new Scanner(System.in);

        System.out.println("Introdusca el numero de alumnos");
        numeroAlumnos = lector.nextInt();

        System.out.println("Introdusca los promedios");
        for(int i=0;i<numeroAlumnos;i++){
            double promedioAlumno = lector.nextDouble();
            promedio +=promedioAlumno;
        }

        System.out.println("El promedio es "+promedio/(double) numeroAlumnos);
    }

}
