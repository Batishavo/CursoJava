import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DetalleVetnaService } from '../detalle-vetna.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-detalle-venta',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './detalle-venta.component.html',
  styleUrl: './detalle-venta.component.css'
})
export class DetalleVentaComponent implements OnInit  {

  private params:any;
  private id:number = 0;
  miLista:any[] = [];
  detalle:any;

  constructor(
    private ruta:ActivatedRoute,
    private servicio:DetalleVetnaService
  ){
    //console.log(parametros["id"]);
    this.params = this.ruta.params.subscribe(parametros =>{
      this.id = parametros["id"];
      //console.log(this.id);
      this.servicio.obtenerDetalleVenta();
    })
    this.miLista = this.servicio.listDetalleVenta;
    //console.log(this.miLista);
  }
  ngOnInit(): void {
    //console.log(this.miLista);
    var tmp:any[] = [];
    this.miLista.forEach((val,index)=>{
      //console.log(index,val.cliente.id);
      if(val.cliente.id==this.id){
        tmp.push(val);
      }
    })
    this.miLista = tmp;
    this.detalle = this.miLista[0].detalle;
    //console.log(this.miLista);
  }

  setDetalle(detalle:any){
    //console.log(detalle);
    this.detalle = detalle;
  }
  

}
