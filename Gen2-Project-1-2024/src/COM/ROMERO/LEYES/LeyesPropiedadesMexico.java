package COM.ROMERO.LEYES;

import COM.ROMERO.ENUMS.Pais;
import COM.ROMERO.INTERFACES.IImpuestos;
import COM.ROMERO.PASIVOS_ACTIVOS.Propiedades;

public class LeyesPropiedadesMexico implements IImpuestos<Propiedades> {

    public Pais pais;

    public LeyesPropiedadesMexico(){
        pais=Pais.MEXICO;
    }

    final static float tasaDeInteres = 0.05f;
    @Override
    public float impuestosApagar(Propiedades c1) {
        return (float)c1.getPrecio()*tasaDeInteres;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
