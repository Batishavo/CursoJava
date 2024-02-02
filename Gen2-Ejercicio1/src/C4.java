import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C4 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        Scanner lectorCadena = new Scanner(System.in);

        int totalCalificaciones = 10;
        System.out.println("Coloque el numero de alumos");
        int numeroDeAlumnos = lector.nextInt();
        int accion;

        List<Integer[]> calificacionesAlumnos = new ArrayList<>();
        List<String> nombreDelAlumno = new ArrayList<String>();

        for (int i = 0; i < numeroDeAlumnos; i++) {
            System.out.println("Nombre del alumno");
            nombreDelAlumno.add(lectorCadena.next());
            System.out.println("Coloque sus 10 calificaciones");
            Integer[] calificaciones = new Integer[totalCalificaciones + 5];
            for (int j = 0; j < totalCalificaciones; j++) {
                calificaciones[j] = lector.nextInt();
            }
            calificacionesAlumnos.add(calificaciones);

        }

        System.out.println("Que desea realizar\n " +
                "1.obtener promedio de cada alumno\n" +
                "2. obetener promedio grupal\n" +
                "3. total de alumnos aprobados\n" +
                "4. toal de alumnos reprobados\n" +
                "5. Buscar alumno por nombre y ver calificaciones\n" +
                "6. finalizar programa\n"
        );

        accion = lector.nextInt();

        while (accion != 6) {
            switch (accion) {
                case 1:
                    for (int i = 0; i < numeroDeAlumnos; i++) {
                        double promedio = 0.0;
                        Integer[] calificaciones = calificacionesAlumnos.get(i);
                        for (int j = 0; j < totalCalificaciones; j++) {
                            promedio += calificaciones[j];
                        }
                        promedio /= totalCalificaciones;
                        System.out.println("El promedio de " + nombreDelAlumno.get(i) + "= " + promedio);
                    }
                    break;
                case 2:
                    double promedioTotal = 0.0;
                    for (int i = 0; i < numeroDeAlumnos; i++) {
                        double promedioActual = 0.0;
                        Integer[] calificaciones = calificacionesAlumnos.get(i);
                        for (int j = 0; j < totalCalificaciones; j++) {
                            promedioActual += calificaciones[j];
                        }
                        promedioTotal += promedioActual / (double) totalCalificaciones;
                    }
                    System.out.println("El promedio Grupal es de " + promedioTotal / (double) numeroDeAlumnos);
                    break;
                case 3:
                    int alumnosAprobado = 0;
                    for (int i = 0; i < numeroDeAlumnos; i++) {
                        double promedioActual = 0.0;
                        Integer[] calificaciones = calificacionesAlumnos.get(i);
                        for (int j = 0; j < totalCalificaciones; j++) {
                            promedioActual += calificaciones[j];
                        }
                        if (promedioActual / (double) totalCalificaciones >= 6.0) {
                            alumnosAprobado++;
                        }
                    }
                    System.out.println("El total de alumnos aprobados es de " + alumnosAprobado);
                    break;
                case 4:
                    int alumnosReprovados = 0;
                    for (int i = 0; i < numeroDeAlumnos; i++) {
                        double promedioActual = 0.0;
                        Integer[] calificaciones = calificacionesAlumnos.get(i);
                        for (int j = 0; j < totalCalificaciones; j++) {
                            promedioActual += calificaciones[j];
                        }
                        if (promedioActual / (double) totalCalificaciones < 6.0) {
                            alumnosReprovados++;
                        }
                    }
                    System.out.println("El total de alumnos reprobados es de " + alumnosReprovados);
                    break;
                case 5:
                    System.out.println("Coloque el nombre del alumno a buscar");
                    String nombreAlumno = lectorCadena.next();
                    boolean flag = false;
                    for (int i = 0; i < numeroDeAlumnos; i++) {
                        if (nombreAlumno.equals(nombreDelAlumno.get(i))) {
                            System.out.println("El almuno tiene las siguientes calificaciones");
                            Integer[] calificaciones = calificacionesAlumnos.get(i);
                            for (int j = 0; j < totalCalificaciones; j++) {
                                System.out.println(calificaciones[j]);
                            }
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("No existe ese alumno");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Coloque un numero");
                    break;
            }
            System.out.println("Que desea realizar\n " +
                    "1.obtener promedio de cada alumno\n" +
                    "2. obetener promedio grupas\n" +
                    "3. total de alumnos aprobados\n" +
                    "4. toal de alumnos reprobados\n" +
                    "5. Buscar alumno por nombre y ver calificaciones\n" +
                    "6. finalizar programa\n"
            );
            accion = lector.nextInt();


        }
    }
}
