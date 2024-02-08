package COM.ROMERO.LEYES;

import COM.ROMERO.ENUMS.Pais;
import COM.ROMERO.INTERFACES.IImpuestos;
import COM.ROMERO.PASIVOS_ACTIVOS.Nomina;

public class LeyesNominaMexico implements IImpuestos<Nomina> {
    private Pais pais;

    public LeyesNominaMexico(){
        pais = Pais.MEXICO;
    }

    @Override
    public float impuestosApagar(Nomina c1) {
        double salarioBruto = c1.calcularSalarioBruto();
        float impuestos = (float)salarioBruto * 0.15f; // Tasa de impuestos del 15%
        return impuestos;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
