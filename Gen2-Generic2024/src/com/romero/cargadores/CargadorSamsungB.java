package com.romero.cargadores;

import com.romero.celulares.CelularSamsung;
import com.romero.interfaces.ICargadorSamsung;

public class CargadorSamsungB implements ICargadorSamsung {
    @Override
    public void cargar(CelularSamsung c1) {
        System.out.println("Soy un cargador Samsung tipo B");
    }
}
