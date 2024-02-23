
import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../../../Services/pokemon.service';
import { Pokemon } from '../../../Interfaces/Pokemon';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vista-pokemon',
  templateUrl: './vista-pokemon.component.html',
  styleUrl: './vista-pokemon.component.css'
})
export class VistaPokemonComponent implements OnInit {
  
  pokemon!:Pokemon;
  id:number = 34;

  constructor(
    private pokemonService:PokemonService,
    private route: ActivatedRoute
  ) { }
  
  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.id = +params['id'];
    });

    //console.log(this.id);
    this.pokemonService.getPokemon(this.id).subscribe(
      data => {
        this.pokemon = data;
      },
      error => {
        console.log(error);
      }
    );
    //console.log(this.pokemon);
  }

}
