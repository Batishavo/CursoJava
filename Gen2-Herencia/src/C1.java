import animales.*;

import java.util.ArrayList;
import java.util.List;

public class C1 {
    public static void main(String[] args) {
        //Creamos los tipos de animalres
        perro perrito = new perro(
                "Frijol",
                "vivíparo",
                "Ladra",
                "hogar",
                "4 patas",
                "Chihuahua"
        );

        cocodrilo crocodile = new cocodrilo(
                "Croki",
                "ovíparo",
                "Sisea",
                "Salvaje",
                "4 patas y nadar",
                "Amazonas"
        );

        Gallina gallina = new Gallina(
                "gallina",
                "ovíparo",
                "cacarea",
                "Domestico de granja",
                "4 patas y aletea",
                "Obscuro"

        );

        List<animal> animales = new ArrayList<>();

        animales.add(perrito);
        animales.add(crocodile);
        animales.add(gallina);

        animales.forEach(animal -> {
            System.out.println(animal.hacerRuido());
            System.out.println(animal.moverse());
            System.out.println(animal.getNombre());
            System.out.println(animal.getTipoDeEstancia());
            System.out.println(animal.getTipoNacimiento());
        });

    }
}
