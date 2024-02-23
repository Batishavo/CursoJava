import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ProductosServiceService } from '../productos-service.service';

@Component({
  selector: 'app-listado-productos',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './listado-productos.component.html',
  styleUrl: './listado-productos.component.css'
})
export class ListadoProductosComponent {

  constructor(public servicio : ProductosServiceService){
    this.servicio.obtenerListaProductos();
  }

  get listaProductos(){
    return this.servicio.listaProductps;
  }

}
