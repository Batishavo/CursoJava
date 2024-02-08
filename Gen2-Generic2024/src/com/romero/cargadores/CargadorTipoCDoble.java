package com.romero.cargadores;

import com.romero.celulares.CelularApple;
import com.romero.interfaces.ICargadorApple;

public class CargadorTipoCDoble implements ICargadorApple {
    @Override
    public void cargar(CelularApple c1) {
        System.out.println("" +
                "soy un cargador apple y puedo cargad " +
                "dos cellilares apple mediante un calbe usb " +
                "tipo C a 35W"
        );
    }
}
