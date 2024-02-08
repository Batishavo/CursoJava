package com.romero.cargadores;

import com.romero.celulares.CelularXiaomi;
import com.romero.interfaces.ICargadorXiaomi;

public class CargadorXiaomiB implements ICargadorXiaomi {

    @Override
    public void cargar(CelularXiaomi c1) {
        System.out.println("Soy un cargador Xiomi tipo B");
    }
}
