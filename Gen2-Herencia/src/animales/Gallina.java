package animales;

public class Gallina extends animal{

    public String tipoDeHuevo;

    public Gallina(){
        super();
    }
    public Gallina(
            String nombre,
            String tipoNacimiento,
            String tipoDeRuido,
            String tipoDeEstancia,
            String tipoDeMovimiento,
            String tipoDeHuevo
    ){
        super(
                nombre,
                tipoNacimiento,
                tipoDeRuido,
                tipoDeEstancia,
                tipoDeMovimiento
        );
        this.tipoDeHuevo = tipoDeHuevo;

    }

    //Getters and Setters


    public String getTipoDeHuevo() {
        return tipoDeHuevo;
    }

    public void setTipoDeHuevo(String tipoDeHuevo) {
        this.tipoDeHuevo = tipoDeHuevo;
    }

    @Override
    public String hacerRuido() {
        return "La gallina "+this.tipoDeRuido;
    }

    @Override
    public String moverse() {
        return "La gallina se mueve a "+this.tipoDeMovimiento;
    }

    public String ponerHuevo(){
        return "La gallina pone un huevo de colo"+this.tipoDeHuevo;
    }
}
