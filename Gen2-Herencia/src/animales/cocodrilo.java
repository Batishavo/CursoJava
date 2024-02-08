package animales;

public class cocodrilo extends animal {
    //atributo
    public String habitad;

    //Contuctores
    public cocodrilo(){
        super();
    }

    public cocodrilo(
            String nombre,
            String tipoNacimiento,
            String tipoDeRuido,
            String tipoDeEstancia,
            String tipoDeMovimiento,
            String habitad
    ){
        super(
                nombre,
                tipoNacimiento,
                tipoDeRuido,
                tipoDeEstancia,
                tipoDeMovimiento
        );
        this.habitad = habitad;
    }

    //Getters and Setters


    public String getHabitad() {
        return habitad;
    }

    public void setHabitad(String habitad) {
        this.habitad = habitad;
    }

    @Override
    public String hacerRuido() {
        return "El cocodrilo "+this.tipoDeRuido;
    }

    @Override
    public String moverse() {
        return "El cocodrilo se mueve a "+this.tipoDeMovimiento;
    }

    public String nadar(){
        return "El cocodrilo nada";
    }


}
