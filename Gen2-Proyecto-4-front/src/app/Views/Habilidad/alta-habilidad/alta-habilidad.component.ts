import { Component, ElementRef, ViewChild } from '@angular/core';
import { Habilidad } from '../../../Interfaces/Habilidad ';
import { HabilidadesService } from '../../../Services/habilidades.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alta-habilidad',
  templateUrl: './alta-habilidad.component.html',
  styleUrl: './alta-habilidad.component.css'
})
export class AltaHabilidadComponent {

  //Atributos|
  habilidad!:Habilidad;

  //Elementos del formulario
  @ViewChild("nombre")
  referenciaNombre!:ElementRef;
  @ViewChild("descripcion")
  referenciaDescripcion!:ElementRef;

  //Cosntructor
  constructor(
    private _servicio:HabilidadesService,
    private _ruta:Router
  ){}
  

  //Metodos
  postPokemon():void{
    const habilidadPost:Habilidad ={
      id:0,
      nombre:this.referenciaNombre.nativeElement.value,
      descripcion:this.referenciaDescripcion.nativeElement.value
    }
    
    this._servicio.postHabilidad(habilidadPost);
    this._ruta.navigate(['habilidad/list']);
  }

  putPokemon(): void {
    this.habilidad.nombre = this.referenciaNombre.nativeElement.value;
    this.habilidad.descripcion = this.referenciaDescripcion.nativeElement.value;
    this._servicio.updateHabilidad(this.habilidad,this.habilidad.id);
    this._ruta.navigate(['habilidad/list']);
  }

  limpiar = () => {
    this.referenciaNombre.nativeElement.value = "";
    this.referenciaDescripcion.nativeElement.value = "";
  };
}
