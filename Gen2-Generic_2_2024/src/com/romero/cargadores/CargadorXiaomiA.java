package com.romero.cargadores;
import com.romero.interfaces.ICargador;
import com.romero.celulares.CelularXiaomi;

public class CargadorXiaomiA implements ICargador<CelularXiaomi> {
    @Override
    public void cargar( CelularXiaomi c1) {

        System.out.println("Soy un cargador Xiomi tipo A");
    }
}
