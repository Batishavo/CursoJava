import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DetalleVetnaService } from '../detalle-vetna.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ventas',
  standalone: true,
  imports: [RouterModule,CommonModule],
  templateUrl: './ventas.component.html',
  styleUrl: './ventas.component.css'
})
export class VentasComponent {
  
  

  mylist:any[]=[];

  constructor(
    private service:DetalleVetnaService
  ){

    this.service.obtenerDetalleVenta();
    this.mylist =this.service.listDetalleVenta;
  }

  get detalleVenta(){
    //console.log( this.service.listDetalleVenta)
    return this.service.listDetalleVenta;
  }

  

}
