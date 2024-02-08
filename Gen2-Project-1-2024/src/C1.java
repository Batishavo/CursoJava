import COM.ROMERO.LEYES.*;
import COM.ROMERO.PASIVOS_ACTIVOS.Nomina;
import COM.ROMERO.PASIVOS_ACTIVOS.Productos;
import COM.ROMERO.PASIVOS_ACTIVOS.Propiedades;

public class C1 {
    public static void main(String[] args) {

        //Pasivos y activos
        Nomina nominaEmpleado = new Nomina("Juan Pérez", 2000.0, 300.0, 40.0);
        Productos producto = new Productos("Camisa", 25.0, 5,0.16f);
        Propiedades propiedad = new Propiedades("123 Calle Principal", 150.0, 3, 200000.0);


        //Leyes
        LeyesNominaMexico pagoNomina = new LeyesNominaMexico();
        LeyesNominaUSA pagoNominaUSA = new LeyesNominaUSA();

        LeyesProductosMexico pagoProductos = new LeyesProductosMexico();
        LeyesProductosUSA pagoProductosUsa = new LeyesProductosUSA();


        LeyesPropiedadesMexico pagoPropiedades = new LeyesPropiedadesMexico();
        LeyesPropiedadesUSA pagoPropiedadesUSA = new LeyesPropiedadesUSA();


        float pagoPorNomina=pagoNomina.impuestosApagar(nominaEmpleado);
        float pagoPorProducto = pagoProductos.impuestosApagar(producto);
        float pagoPorPropiedades = pagoPropiedades.impuestosApagar(propiedad);

        float pagoPorNominaUsa=pagoNominaUSA.impuestosApagar(nominaEmpleado);
        float pagoPorProductoUsa = pagoProductosUsa.impuestosApagar(producto);
        float pagoPorPropiedadesUSA = pagoPropiedadesUSA.impuestosApagar(propiedad);

        System.out.println("impuestos por nomina es "+pagoPorNomina +" en "+pagoNomina.getPais());
        System.out.println("impuestos por el producto es "+pagoPorProducto+" en "+pagoProductos.getPais());
        System.out.println("impuestos por la propiead es "+pagoPorPropiedades+" en "+pagoPropiedades.getPais());

        System.out.println("impuestos por nomina es "+pagoPorNominaUsa +" en "+pagoNominaUSA.getPais());
        System.out.println("impuestos por el producto es "+pagoPorProductoUsa+" en "+pagoProductosUsa.getPais());
        System.out.println("impuestos por la propiead es "+pagoPorPropiedadesUSA+" en "+pagoPropiedadesUSA.getPais());
    }
}
