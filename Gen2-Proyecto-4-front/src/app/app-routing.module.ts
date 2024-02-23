import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListPokemonComponent } from './Views/Pokemon/list-pokemon/list-pokemon.component';
import { AltaPokemonComponent } from './Views/Pokemon/alta-pokemon/alta-pokemon.component';
import { ListMovimientosComponent } from './Views/Movimientos/list-movimientos/list-movimientos.component';
import { AltaMovimientosComponent } from './Views/Movimientos/alta-movimientos/alta-movimientos.component';
import { ListHabilidadComponent } from './Views/Habilidad/list-habilidad/list-habilidad.component';
import { AltaHabilidadComponent } from './Views/Habilidad/alta-habilidad/alta-habilidad.component';
import { VistaPokemonComponent } from './Views/Pokemon/vista-pokemon/vista-pokemon.component';
import { EditPokemonComponent } from './Views/Pokemon/edit-pokemon/edit-pokemon.component';

const routes: Routes = [
  {
    path:'pokemon/list',
    component:ListPokemonComponent
  },
  {
    path:'pokemon/alta',
    component:AltaPokemonComponent
  },
  {
    path:'movimientos/list',
    component:ListMovimientosComponent
  },
  {
    path:'movimientos/alta',
    component:AltaMovimientosComponent
  },
  {
    path:'habilidad/list',
    component:ListHabilidadComponent
  },
  {
    path:'habiliad/alta',
    component:AltaHabilidadComponent
  },
  {
    path:'pokemon/vista',
    component:VistaPokemonComponent
  },
  {
    path:'pokemon/editar',
    component:EditPokemonComponent
  },
  {
    path:'**',
    redirectTo:'pokemon/list'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})



export class AppRoutingModule { }
