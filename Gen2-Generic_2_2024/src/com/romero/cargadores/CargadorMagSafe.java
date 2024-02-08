package com.romero.cargadores;

import com.romero.celulares.CelularApple;
import com.romero.interfaces.ICargador;

public class CargadorMagSafe implements ICargador<CelularApple> {
    @Override
    public void cargar(CelularApple c1) {
        System.out.println("soy un cargadro apple y cargo de manera inalambira a 20 ");
    }
}
