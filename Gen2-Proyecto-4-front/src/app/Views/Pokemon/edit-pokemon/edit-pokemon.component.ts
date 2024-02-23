import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, map, startWith } from 'rxjs';
import { Habilidad } from '../../../Interfaces/Habilidad ';
import { Movimiento } from '../../../Interfaces/Movimiento';
import { Pokemon } from '../../../Interfaces/Pokemon';
import { TiposService } from '../../../Services/tipos.service';
import { HabilidadesService } from '../../../Services/habilidades.service';
import { PokemonService } from '../../../Services/pokemon.service';
import { MovimientosService } from '../../../Services/movimientos.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PokemonDTO } from '../../../Interfaces/PokemonDTO';

@Component({
  selector: 'app-edit-pokemon',
  templateUrl: './edit-pokemon.component.html',
  styleUrl: './edit-pokemon.component.css'
})
export class EditPokemonComponent {
  myControl = new FormControl();
  filteredOptions!: Observable<Habilidad[]>;

  posMovimientos:Movimiento[]= [];
  movimientos:Movimiento[]= [];
  movimientosPokemon!:Movimiento[];
  id:number = 0; 
  initHabilidad!:Habilidad;

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
    private route: ActivatedRoute,
    private _router:Router
  ){
    this.route.queryParams.subscribe(params => {
      this.id = +params['id'];
    });
    this.pokemonService.getPokemonById(this.id);
    this.tiposService.getTipos();
    this.habilidadService.getHabilidades();
    this.habilidadService.habilidades.forEach(habilidad =>{
      if(habilidad.id === this.pokemonService.pokemon.habilidad.id){
        this.initHabilidad = habilidad;
        return;
      }
    })
    this.habilidadService.getHabilidad(this.pokemon.habilidad.id);
    //console.log(this.pokemonService.pokemon);
    this.refereciaTipoPrimario = this.pokemon.tipoPrimario;
    this.referenciaTipoSecundario = this.pokemon.tipoSecundario;
    this.movimientosPokemon = this.pokemon.movimientos;
    this.posMovimientos = this.movimientosPokemon;
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
    
    this.habilidades.sort((a, b) => (a.nombre < b.nombre ? -1:1));
    this.movimientos.sort((a, b) => (a.nombre < b.nombre ? -1:1));
    
   
   
  }

  private _filter(value: string): Habilidad[] {
    const filterValue = value.toLowerCase();
    return this.habilidades.filter(habilidad => habilidad.nombre.toLowerCase().includes(filterValue));
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

  get pokemon(){
    return this.pokemonService.pokemon;
  }

  get habilidades(){
    return this.habilidadService.habilidades;
  }

  get habilidad(){
    return this.pokemon.habilidad;
  }

  get tipos(){
    return this.tiposService.tipos;
  }

  editPokemon(){
    let movimientos:number[] = [];
    
    this.posMovimientos.forEach(movimiento => {
      movimientos.push(movimiento.id);
    })

    const pokemon:PokemonDTO = {
      id: this.pokemon.id,
      nombre: this.referenciaNombre.nativeElement.value,
      tipoPrimario: this.refereciaTipoPrimario,
      tipoSecundario: this.referenciaTipoSecundario,
      altura: this.referenciaAltura.nativeElement.value,
      peso: this.referenciaPeso.nativeElement.value,
      descripcion: this.referenciaDescripcion.nativeElement.value,
      estadisticas: {
        id:this.pokemon.estadisticas.id,
        hp: this.referenciaHp.nativeElement.value,
        ataque: this.referenciaAtaque.nativeElement.value,
        defensa: this.referenciaDefensa.nativeElement.value,
        ataqueEspecial: this.referenciaAtaqueEspecial.nativeElement.value,
        defensaEspecial: this.referenciaDefensaEspecial.nativeElement.value,
        velocidad: this.referenciaVelocidad.nativeElement.value
      },
      habilidad:this.initHabilidad.id,
      movimientos: movimientos,
      imagen:this.referenciaImagen.nativeElement.value
    }
    this.pokemonService.updatePokemon(pokemon, this.pokemon.id);
    this._router.navigate(['pokemon/list']);
  }
}
