package com.romero.cargadores;

import com.romero.celulares.CelularApple;
import com.romero.interfaces.ICargador;

public class CargadorTipoC implements ICargador<CelularApple> {
    @Override
    public void cargar(CelularApple c1) {
        System.out.println("Soy un cargador y cargo mediante un cable usb tupo c a 20W");
    }
}
