package com.romero.cargadores;

import com.romero.celulares.CelularXiaomi;
import com.romero.interfaces.ICargadorXiaomi;

public class CargadorXiaomiA implements ICargadorXiaomi {
    @Override
    public void cargar(CelularXiaomi c1) {
        System.out.println("Soy un cargador Xiomi tipo A");
    }
}
