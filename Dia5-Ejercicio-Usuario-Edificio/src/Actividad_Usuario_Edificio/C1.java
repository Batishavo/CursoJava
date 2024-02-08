package Actividad_Usuario_Edificio;

public class C1 {
    public static void main(String[] args) {
        //Alumnos
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Pepe");
        alumno1.setEdad(25);
        alumno1.setMatricula("pepe12345");
        alumno1.setNumDeSalon(10);
        alumno1.setNombreDeEdificio("TrNetwork");
        alumno1.setCalificacion(6);

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Ana");
        alumno2.setEdad(22);
        alumno2.setMatricula("ana56789");
        alumno2.setNumDeSalon(15);
        alumno2.setNombreDeEdificio("Ciencias");
        alumno2.setCalificacion(8);
        //---------------------------
        //Profesores
        profesor profesor1 = new profesor();
        profesor1.setNombre("Pancho");
        profesor1.setNumTrabajador("pancho123");
        profesor1.setEdad(40);
        profesor1.setNumDeSalon(10);
        profesor1.setNombreDeEdificio("TrNetwork");

        profesor profesor2 = new profesor();
        profesor2.setNombre("María");
        profesor2.setNumTrabajador("maria987");
        profesor2.setEdad(35);
        profesor2.setNumDeSalon(15);
        profesor2.setNombreDeEdificio("Ciencias");
        //--------------------

        //Edificios
        Edificio edificio1 = new Edificio();
        edificio1.setNombreDeEdificio("TrNetwork");
        edificio1.setNumDeSalon(10);

        Edificio edificio2 = new Edificio();
        edificio2.setNombreDeEdificio("Ciencias");
        edificio2.setNumDeSalon(15);

        edificio1.verificarEdificio(alumno1.getNombreDeEdificio());
        edificio2.verificarEdificio(alumno1.getNombreDeEdificio());
        System.out.println("----------------------------");
        edificio1.verificarNumDeSalon(alumno1.getNumDeSalon());
        edificio2.verificarNumDeSalon(alumno1.getNumDeSalon());
        System.out.println("----------------------------");
        alumno1.HacerExamen(alumno1.getNombre(),profesor1.getNombre());
        alumno2.HacerExamen(alumno2.getNombre(),profesor2.getNombre());
        System.out.println("----------------------------");
        profesor1.calificarExamen(alumno1.getNombre(),alumno1.getCalificacion());
        profesor2.calificarExamen(alumno2.getNombre(), alumno2.getCalificacion());
        System.out.println("----------------------------");

    }
}
