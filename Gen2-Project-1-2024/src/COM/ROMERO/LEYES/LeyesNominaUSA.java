package COM.ROMERO.LEYES;

import COM.ROMERO.ENUMS.Pais;
import COM.ROMERO.INTERFACES.IImpuestos;
import COM.ROMERO.PASIVOS_ACTIVOS.Nomina;

public class LeyesNominaUSA implements IImpuestos<Nomina> {

    private Pais pais;

    public LeyesNominaUSA(){
        pais = Pais.USA;
    }
    @Override
    public float impuestosApagar(Nomina c1) {
        double salarioBruto = c1.calcularSalarioBruto();
        float impuestos = (float)salarioBruto * 0.8f; // Tasa de impuestos del 15%
        return impuestos;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
