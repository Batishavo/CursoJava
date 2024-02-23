import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ListPokemonComponent } from './Pokemon/list-pokemon/list-pokemon.component';
import { AltaPokemonComponent } from './Pokemon/alta-pokemon/alta-pokemon.component';
import { ListMovimientosComponent } from './Movimientos/list-movimientos/list-movimientos.component';
import { AltaMovimientosComponent } from './Movimientos/alta-movimientos/alta-movimientos.component';
import { ListHabilidadComponent } from './Habilidad/list-habilidad/list-habilidad.component';
import { AltaHabilidadComponent } from './Habilidad/alta-habilidad/alta-habilidad.component';
import { VistaPokemonComponent } from './Pokemon/vista-pokemon/vista-pokemon.component';

const routes:Routes = [
  {
    path:'',
    children:[
     
    ]
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class ViewRoutingModule { }
