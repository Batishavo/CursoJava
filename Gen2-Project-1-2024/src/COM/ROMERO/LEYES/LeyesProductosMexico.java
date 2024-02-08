package COM.ROMERO.LEYES;

import COM.ROMERO.ENUMS.Pais;
import COM.ROMERO.INTERFACES.IImpuestos;
import COM.ROMERO.PASIVOS_ACTIVOS.Productos;

public class LeyesProductosMexico implements IImpuestos<Productos> {

    private Pais pais;
    public LeyesProductosMexico(){
        pais=Pais.MEXICO;
    }
    @Override
    public float impuestosApagar(Productos c1) {
        return (float)c1.getPrecio() * c1.getTasaImpuestos();
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
