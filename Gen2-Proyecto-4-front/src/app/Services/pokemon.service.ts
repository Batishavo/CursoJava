import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../Interfaces/Pokemon';
import { PokemonDTO } from '../Interfaces/PokemonDTO';
import { environment } from '../../environment/environments';
import { response } from 'express';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  pokemon!:Pokemon;
  pokemons:Pokemon[] = [];

  constructor(private http:HttpClient) { }

  public getPokemons(): Observable<Pokemon[]> {
    //console.log(this.http.get<Pokemon[]>(`${environment.myApi}/pokemon`));
    return this.http.get<Pokemon[]>(`${environment.myApi}/pokemon`);
  }

  public getPokemon(id:number): Observable<Pokemon> {
    //console.log(this.http.get<Pokemon>(`${environment.myApi}/pokemon/${id}`));
    return this.http.get<Pokemon>(`${environment.myApi}/pokemon/obener/${id}`);
  }

  public getPokemonById(id: number):void{
    this.http.get<Pokemon>(`${environment.myApi}/pokemon/obener/${id}`).subscribe(
      data => {
        this.pokemon = data;
      },
      error => {
        console.error('Error al obtener Pokemon:', error);
      }
    )
  }

  public updatePokemon(pokemon:PokemonDTO, id:number):void {
    this.http.put<PokemonDTO>(`${environment.myApi}/pokemon/actualizar/${id}`,pokemon).subscribe(
      response=>{
        console.log(response);
      }
    );
  }

  public postPokemon(pokemon:PokemonDTO):void{
    this.http.post<PokemonDTO>(`${environment.myApi}/pokemon`,pokemon).subscribe();
  }
  
  public deletePokemon(id:number):void{
    this.http.delete<Pokemon>(`${environment.myApi}/pokemon/eliminar/${id}`).subscribe();
  }

}
