import { Component, ElementRef, OnInit, ViewChild, viewChild } from '@angular/core';
import { Pokemon } from '../../../Interfaces/Pokemon';
import { TiposService } from '../../../Services/tipos.service';
import { Habilidad } from '../../../Interfaces/Habilidad ';
import { HabilidadesService } from '../../../Services/habilidades.service';
import { PokemonService } from '../../../Services/pokemon.service';
import { Movimiento } from '../../../Interfaces/Movimiento';
import { MovimientosService } from '../../../Services/movimientos.service';
import { FormControl } from '@angular/forms';
import { Observable, map, startWith } from 'rxjs';
import { PokemonDTO } from '../../../Interfaces/PokemonDTO';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alta-pokemon',
  templateUrl: './alta-pokemon.component.html',
  styleUrl: './alta-pokemon.component.css'
})
export class AltaPokemonComponent implements OnInit{

  myControl = new FormControl();
  filteredOptions!: Observable<Habilidad[]>;
  
  movimientos:Movimiento[]= [];
  movimientosPokemon!:Movimiento[];
  posMovimientos:Movimiento[]= [];
  habiliad!:Habilidad;

  refereciaTipoPrimario:string = "";
  referenciaTipoSecundario:string = "";

  @ViewChild("nombre")  
  referenciaNombre!:ElementRef;
  @ViewChild("altura")
  referenciaAltura!:ElementRef;
  @ViewChild("peso")
  referenciaPeso!:ElementRef;
  @ViewChild("descripcion")
  referenciaDescripcion!:ElementRef;
  @ViewChild("hp")
  referenciaHp!:ElementRef;
  @ViewChild("ataque")
  referenciaAtaque!:ElementRef;
  @ViewChild("defensa")
  referenciaDefensa!:ElementRef;
  @ViewChild("ataqueEspecial")
  referenciaAtaqueEspecial!:ElementRef;
  @ViewChild("defensaEspecial")
  referenciaDefensaEspecial!:ElementRef;
  @ViewChild("velocidad")
  referenciaVelocidad!:ElementRef;
  @ViewChild("imagen")
  referenciaImagen!:ElementRef;

  constructor(
    private tiposService:TiposService,
    private habilidadService:HabilidadesService,
    private pokemonService:PokemonService,
    private movimientoService:MovimientosService,
    private _router:Router
    
    
  ){
    this.tiposService.getTipos();
    this.habilidadService.getHabilidades(); //
  }
  
  ngOnInit(): void {
    
    this.movimientoService.getMovimientos().subscribe(
      movimientos => {
        this.movimientos = movimientos;
      },
      error =>{
        console.error('Error al obtener movimientos:', error);
      }
    )
    
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value)) // Utiliza el método _filter para filtrar las habilidades
    );
    
  
    this.movimientos.sort((a, b) => (a.nombre < b.nombre ? -1:1));
   
  }

  private _filter(value: string): Habilidad[] {
    const filterValue = value.toLowerCase();
    return this.habilidades.filter(habilidad => habilidad.nombre.toLowerCase().includes(filterValue));
  }
  
  get habilidades(){
    return this.habilidadService.habilidades;
  }

  displayHabilidad(habilidad: Habilidad): string {
    if(habilidad){
      return habilidad.nombre;
    }
    return "";
  }

  displayMovimiento(movimiento: Movimiento):string {
    if(movimiento){
      return movimiento.nombre;
    }
    return "";
  }

  compareMovimientos(movimiento1: Movimiento, movimiento2: Movimiento): boolean {
    return movimiento1 && movimiento2 ? movimiento1.id === movimiento2.id : movimiento1 === movimiento2;
  }

  get tipos(){
    return this.tiposService.tipos;
  }

  limpiar = () => {
    
  }

  postPokemon= () => {

    let movimientos:number[] = [];
    
    this.posMovimientos.forEach(movimiento => {
      movimientos.push(movimiento.id);
    })

    const pokemon:PokemonDTO = {
      id: 0,
      nombre: this.referenciaNombre.nativeElement.value,
      tipoPrimario: this.refereciaTipoPrimario,
      tipoSecundario: this.referenciaTipoSecundario,
      altura: this.referenciaAltura.nativeElement.value,
      peso: this.referenciaPeso.nativeElement.value,
      descripcion: this.referenciaDescripcion.nativeElement.value,
      estadisticas: {
        id:0,
        hp: this.referenciaHp.nativeElement.value,
        ataque: this.referenciaAtaque.nativeElement.value,
        defensa: this.referenciaDefensa.nativeElement.value,
        ataqueEspecial: this.referenciaAtaqueEspecial.nativeElement.value,
        defensaEspecial: this.referenciaDefensaEspecial.nativeElement.value,
        velocidad: this.referenciaVelocidad.nativeElement.value
      },
      habilidad:this.habiliad.id,
      movimientos: movimientos,
      imagen:this.referenciaImagen.nativeElement.value
    }
    //console.log(pokemon);
    this.pokemonService.postPokemon(pokemon);
    this._router.navigate(['pokemon/list']);
  };

}
