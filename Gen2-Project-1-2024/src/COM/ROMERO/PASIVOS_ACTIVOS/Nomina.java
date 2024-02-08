package COM.ROMERO.PASIVOS_ACTIVOS;

public class Nomina {
    private String empleadoNombre;
    private double salarioBase;
    private double deducciones;
    private double horasTrabajadas;

    // Constructor
    public Nomina(String empleadoNombre, double salarioBase, double deducciones, double horasTrabajadas) {
        this.empleadoNombre = empleadoNombre;
        this.salarioBase = salarioBase;
        this.deducciones = deducciones;
        this.horasTrabajadas = horasTrabajadas;
    }

    // Métodos para obtener y establecer los valores de los atributos
    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(double deducciones) {
        this.deducciones = deducciones;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    // Método para calcular el salario neto
    public double calcularSalarioNeto() {
        return salarioBase - deducciones;
    }

    // Método para calcular el salario bruto
    public double calcularSalarioBruto() {
        // Supongamos que el salario bruto es el salario base más una bonificación por horas trabajadas
        // Puedes ajustar esta lógica según tus necesidades específicas
        return salarioBase + (horasTrabajadas * 10); // Suponiendo una bonificación de $10 por hora trabajada
    }

}
