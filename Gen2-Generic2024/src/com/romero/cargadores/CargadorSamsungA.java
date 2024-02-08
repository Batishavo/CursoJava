package com.romero.cargadores;

import com.romero.celulares.CelularSamsung;
import com.romero.interfaces.ICargadorSamsung;

public class CargadorSamsungA implements ICargadorSamsung {
    @Override
    public void cargar(CelularSamsung c1) {
        System.out.println("Soy un cargador Samsun tipoA");
    }
}
