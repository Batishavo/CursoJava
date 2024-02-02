import java.util.Scanner;

public class C6 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double promedioVoltaje = 0.0;

        System.out.println("Introduce 3 voltajes");

        for(int i =0;i<3;i++){
            int voltajeActual = lector.nextInt();
            promedioVoltaje +=voltajeActual;
        }

        promedioVoltaje /= 3.0;

        if(promedioVoltaje<=115.0){
            System.out.println("VOLTAJE VÁLIDO");
        }
        else if(promedioVoltaje>=115.0 && promedioVoltaje<=220.0){
            System.out.println("ALTO VOLTAJE");
        }
        else{
            System.out.println("PELIGRO");
        }
    }
}
