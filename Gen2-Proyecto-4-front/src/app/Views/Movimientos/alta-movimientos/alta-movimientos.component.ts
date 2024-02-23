import { Component, ElementRef, ViewChild } from '@angular/core';
import { Movimiento } from '../../../Interfaces/Movimiento';
import { TiposService } from '../../../Services/tipos.service';
import { MovimientosService } from '../../../Services/movimientos.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-alta-movimientos',
  templateUrl: './alta-movimientos.component.html',
  styleUrl: './alta-movimientos.component.css'
})
export class AltaMovimientosComponent  {

  referenciaTipo: string ="";

  @ViewChild("nombre")
  referenciaNombre!:ElementRef;
  @ViewChild("descripcion")
  referenciaDescripcion!:ElementRef;
  @ViewChild("poder")
  referenciaPoder!:ElementRef;
  @ViewChild("precision")
  referenciaPrecision!:ElementRef;
  @ViewChild("pp")
  referenciaPP!:ElementRef;

  constructor(
    private tiposService:TiposService,
    private _movimientosService:MovimientosService,
    private _ruta:Router
  ){
    this.tiposService.getTipos();
  }

  get tipos(){
    return this.tiposService.tipos;
  }

  postMovimiento():void{

    const movimientoPost:Movimiento={
      id:0,
      nombre:this.referenciaNombre.nativeElement.value,
      tipo:this.referenciaTipo,
      descipcion:this.referenciaDescripcion.nativeElement.value,
      poder:this.referenciaPoder.nativeElement.value,
      precision:this.referenciaPrecision.nativeElement.value,
      pp:this.referenciaPP.nativeElement.value
    }
    /*console.log(
      this.referenciaNombre.nativeElement.value,
      
      this.referenciaTipo.nativeElement.value,
      this.referenciaDescripcion.nativeElement.value,
      this.referenciaPoder.nativeElement.value,
      this.referenciaPrecision.nativeElement.value,
      this.referenciaPP.nativeElement.value
    )*/
    this._movimientosService.postMovimiento(movimientoPost);
    this._ruta.navigate(['movimientos/list']);

  }

  limpiar = () => {
    this.referenciaNombre.nativeElement.value = "";
    this.referenciaDescripcion.nativeElement.value = "";
    this.referenciaPoder.nativeElement.value = "";
    this.referenciaPrecision.nativeElement.value = "";
    this.referenciaPP.nativeElement.value = "";
  }



}
