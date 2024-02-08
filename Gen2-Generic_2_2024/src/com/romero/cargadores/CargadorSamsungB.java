package com.romero.cargadores;

import com.romero.celulares.CelularSamsung;
import com.romero.interfaces.ICargador;

public class CargadorSamsungB implements ICargador<CelularSamsung> {
    @Override
    public void cargar(CelularSamsung c1) {
        System.out.println("Soy un cargador Samsung tipo B");
    }
}
