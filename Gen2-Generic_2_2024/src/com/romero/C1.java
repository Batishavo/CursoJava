package com.romero;

import com.romero.cargadores.*;
import com.romero.celulares.CelularApple;
import com.romero.celulares.CelularSamsung;
import com.romero.celulares.CelularXiaomi;
import com.romero.interfaces.ICargador;

public class C1 {
    public static void main(String[] args) {

        CelularApple iphone14 = new CelularApple();
        CelularSamsung s24 = new CelularSamsung();
        CelularXiaomi poco = new CelularXiaomi();

        ICargador ca1 = new CargadorMagSafe();
        ICargador ca2 = new CargadorTipoC();
        ICargador ca3 = new CargadorTipoCDoble();

        ICargador cs1 = new CargadorSamsungA();
        ICargador cs2 = new CargadorSamsungB();

        ICargador cx1 = new CargadorXiaomiA();
        ICargador cx2 = new CargadorXiaomiB();

        ca1.cargar(iphone14);
        cs1.cargar(s24);
        cx1.cargar(poco);

        ca2.cargar(iphone14);
        ca3.cargar(iphone14);

        cs2.cargar(s24);
        cx2.cargar(poco);

    }
}
