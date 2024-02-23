import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../../../Interfaces/Pokemon';
import { PokemonService } from '../../../Services/pokemon.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-pokemon',
  templateUrl: './list-pokemon.component.html',
  styleUrl: './list-pokemon.component.css'
})
export class ListPokemonComponent implements OnInit  {
  
  pokemons:Pokemon[] = [];
  ELEMENT_DATA :Pokemon[] = [];
  
  pokemon:Pokemon = {
    id: 0,
    nombre: '',
    tipoPrimario: '',
    tipoSecundario: '',
    altura: 0,
    peso: 0,
    descripcion: '',
    estadisticas: {
      id:0,
      hp: 0,
      ataque: 0,
      defensa: 0,
      ataqueEspecial: 0,
      defensaEspecial: 0,
      velocidad: 0
    },
    habilidad:{
      id: 0,
      nombre: '',
      descripcion: ''
    },
    movimientos: [],
    imagen:''
  }
  displayedColumns: string[] = ['id','nombre',"tipo","detalle","editar","eliminar"];
  dataSource = this.ELEMENT_DATA;

  constructor(
    private pokemonService:PokemonService,
    private _router:Router
  ){}

  ngOnInit(): void {
    this.pokemonService.getPokemons()
    .subscribe(data => {
      this.pokemons = data
    });
    //console.log(this.pokemons);
    this.ELEMENT_DATA = this.pokemons;
    this.dataSource = this.ELEMENT_DATA;
  }

  setPokemon = ( id:number )=>{
    
    const pokemonEncontrado = this.ELEMENT_DATA.find(e => e.id === id );
    if( pokemonEncontrado !== undefined){
      this.pokemon = pokemonEncontrado;
    }
    else{
      console.log("Pokemon not found");
    }
  }

  deletePokemon = (id:number) => {
    this.pokemonService.deletePokemon(id);
    this._router.navigate(['pokemon/list']);
  }

}
