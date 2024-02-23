import { Estadisticas } from "./Estadisticas";
import { Habilidad } from "./Habilidad ";
import { Movimiento } from "./Movimiento";

export interface Pokemon {
    id: number;
    nombre: string;
    tipoPrimario: string;
    tipoSecundario: string;
    altura: number;
    peso: number;
    descripcion: string;
    estadisticas: Estadisticas;
    imagen:string
    habilidad: Habilidad;
    movimientos: Movimiento[];
}
