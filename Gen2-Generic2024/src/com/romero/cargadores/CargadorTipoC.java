package com.romero.cargadores;

import com.romero.celulares.CelularApple;
import com.romero.interfaces.ICargadorApple;

public class CargadorTipoC implements ICargadorApple {
    @Override
    public void cargar(CelularApple c1) {
        System.out.println("Soy un cargador y cargo mediante un cable usb tupo c a 20W");
    }
}
