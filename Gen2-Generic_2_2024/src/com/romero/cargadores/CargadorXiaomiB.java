package com.romero.cargadores;
import com.romero.interfaces.ICargador;
import com.romero.celulares.CelularXiaomi;

public class CargadorXiaomiB implements ICargador<CelularXiaomi> {

    @Override
    public void cargar(CelularXiaomi c1) {
        System.out.println("Soy un cargador Xiomi tipo B");
    }
}
