package com.romero.cargadores;

import com.romero.celulares.CelularApple;
import com.romero.interfaces.ICargadorApple;

public class CargadorMagSafe implements ICargadorApple {
    @Override
    public void cargar(CelularApple c1) {
        System.out.println("soy un cargadro apple y cargo de manera inalambira a 20 ");
    }
}
