//Dependencis
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatSelectModule} from '@angular/material/select';
import {MatTableModule} from '@angular/material/table';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import {AsyncPipe} from '@angular/common';
import {MatAutocompleteModule} from '@angular/material/autocomplete';


//My libraries
import { AltaHabilidadComponent } from './Habilidad/alta-habilidad/alta-habilidad.component';
import { AltaMovimientosComponent } from './Movimientos/alta-movimientos/alta-movimientos.component';
import { AltaPokemonComponent } from './Pokemon/alta-pokemon/alta-pokemon.component';
import { ListHabilidadComponent } from './Habilidad/list-habilidad/list-habilidad.component';
import { ListMovimientosComponent } from './Movimientos/list-movimientos/list-movimientos.component';
import { ListPokemonComponent } from './Pokemon/list-pokemon/list-pokemon.component';
import { VistaPokemonComponent } from './Pokemon/vista-pokemon/vista-pokemon.component';
import { EditPokemonComponent } from './Pokemon/edit-pokemon/edit-pokemon.component';

@NgModule({
  declarations: [
    AltaPokemonComponent,
    ListPokemonComponent,
    AltaHabilidadComponent,
    ListHabilidadComponent,
    AltaMovimientosComponent,
    ListMovimientosComponent,
    VistaPokemonComponent,
    EditPokemonComponent,
    
  ],
  imports: [
    AsyncPipe, 
    CommonModule,
    FormsModule,
    FormsModule,
    MatAutocompleteModule,
    MatButtonModule, 
    MatCardModule,
    MatDividerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatProgressBarModule,
    MatSelectModule,
    MatTableModule,
    ReactiveFormsModule
  ],
  exports: [
    AltaPokemonComponent,
    ListPokemonComponent,
    AltaHabilidadComponent,
    ListHabilidadComponent,
    
  ]
})
export class ViewModule { }
