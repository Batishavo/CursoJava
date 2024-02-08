package COM.ROMERO.LEYES;

import COM.ROMERO.ENUMS.Pais;
import COM.ROMERO.INTERFACES.IImpuestos;
import COM.ROMERO.PASIVOS_ACTIVOS.Productos;

public class LeyesProductosUSA implements IImpuestos<Productos> {

    private Pais pais;
    public LeyesProductosUSA(){
        pais=Pais.USA;
    }
    @Override
    public float impuestosApagar(Productos c1) {

        return (float)c1.getPrecio() * c1.getTasaImpuestos()*0.95f;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
