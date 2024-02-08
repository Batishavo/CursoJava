package animales;

public abstract class animal {
    //Atributos
    public String nombre;
    public String tipoNacimiento;
    public String tipoDeRuido;
    public String tipoDeEstancia;
    public String tipoDeMovimiento;

    //Contructores
    public animal(){};

    public animal(
            String nombre,
            String tipoNacimiento,
            String tipoDeRuido,
            String tipoDeEstancia,
            String tipoDeMovimiento
    ){
        this.nombre = nombre;
        this.tipoNacimiento = tipoNacimiento;
        this.tipoDeRuido = tipoDeRuido;
        this.tipoDeEstancia = tipoDeEstancia;
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public String getTipoDeEstancia() {
        return tipoDeEstancia;
    }

    public String getTipoDeRuido() {
        return tipoDeRuido;
    }

    public String getTipoNacimiento() {
        return tipoNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoDeEstancia(String tipoDeEstancia) {
        this.tipoDeEstancia = tipoDeEstancia;
    }

    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    public void setTipoDeRuido(String tipoDeRuido) {
        this.tipoDeRuido = tipoDeRuido;
    }

    public void setTipoNacimiento(String tipoNacimiento) {
        this.tipoNacimiento = tipoNacimiento;
    }

    //Metodos
    public abstract String hacerRuido();
    public abstract String moverse();


}
