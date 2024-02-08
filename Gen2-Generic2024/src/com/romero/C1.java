package com.romero;

import com.romero.cargadores.*;
import com.romero.celulares.CelularApple;
import com.romero.celulares.CelularSamsung;
import com.romero.celulares.CelularXiaomi;
import com.romero.interfaces.ICargadorApple;
import com.romero.interfaces.ICargadorSamsung;
import com.romero.interfaces.ICargadorXiaomi;

public class C1 {
    public static void main(String[] args) {

        CelularApple iphone14 = new CelularApple();
        CelularSamsung s24 = new CelularSamsung();
        CelularXiaomi poco = new CelularXiaomi();

        ICargadorApple ca1 = new CargadorMagSafe();
        ICargadorApple ca2 = new CargadorTipoC();
        ICargadorApple ca3 = new CargadorTipoCDoble();

        ICargadorSamsung cs1 = new CargadorSamsungA();
        ICargadorSamsung cs2 = new CargadorSamsungB();

        ICargadorXiaomi cx1 = new CargadorXiaomiA();
        ICargadorXiaomi cx2 = new CargadorXiaomiB();

        ca1.cargar(iphone14);
        cs1.cargar(s24);
        cx1.cargar(poco);

        ca2.cargar(iphone14);
        ca3.cargar(iphone14);

        cs2.cargar(s24);
        cx2.cargar(poco);

    }
}
