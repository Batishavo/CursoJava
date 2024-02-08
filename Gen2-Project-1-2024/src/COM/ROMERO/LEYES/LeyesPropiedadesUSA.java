package COM.ROMERO.LEYES;

import COM.ROMERO.ENUMS.Pais;
import COM.ROMERO.INTERFACES.IImpuestos;
import COM.ROMERO.PASIVOS_ACTIVOS.Propiedades;

public class LeyesPropiedadesUSA implements IImpuestos<Propiedades> {

    public Pais pais;

    public LeyesPropiedadesUSA(){
        pais=Pais.USA;
    }
    final static float tasaDeInteres = 0.03f;
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
