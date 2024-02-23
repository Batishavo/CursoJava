import { Estadisticas } from "./Estadisticas";

export interface PokemonDTO {
    id: number;
    nombre: string;
    tipoPrimario: string;
    tipoSecundario: string;
    altura: number;
    peso: number;
    descripcion: string;
    estadisticas: Estadisticas;
    imagen:string
    habilidad: number;
    movimientos: number[];
}