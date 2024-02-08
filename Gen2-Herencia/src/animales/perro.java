package animales;

public class perro extends animal {

    //atributos
    public String raza;

    //constructores

    public perro(){
        super();
    }
    public perro(
            String nombre,
            String tipoNacimiento,
            String tipoDeRuido,
            String tipoDeEstancia,
            String tipoDeMovimiento,
            String raza
    ){
        super(
                nombre,
                tipoNacimiento,
                tipoDeRuido,
                tipoDeEstancia,
                tipoDeMovimiento
        );

        this.raza = raza;

    }
    //Getters and seters

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    //Metodos
    @Override
    public String hacerRuido() {
        return "El perro "+this.tipoDeRuido;
    }

    @Override
    public String moverse() {
        return "El perro se mueve a"+tipoDeMovimiento;
    }

    public  String moverLaCola(){
        return "El perro mueve la cola";
    }
}
