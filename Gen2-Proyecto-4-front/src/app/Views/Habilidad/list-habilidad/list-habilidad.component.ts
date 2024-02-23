import { Component, ElementRef, OnChanges, SimpleChanges, ViewChild} from '@angular/core';
import { HabilidadesService } from '../../../Services/habilidades.service';
import {  Router } from '@angular/router';
import { Habilidad } from '../../../Interfaces/Habilidad ';

@Component({
  selector: 'app-list-habilidad',
  templateUrl: './list-habilidad.component.html',
  styleUrl: './list-habilidad.component.css'
})
export class ListHabilidadComponent  {
  
  //Atributos
  displayedColumns: string[] = ['id','nombre',"descripcion","detalle","editar","eliminar"];
  dataSource:Habilidad[]=[];
  habilidadSelecionada:Habilidad={
    id: 0,
    nombre: '',
    descripcion: ''
  }

  @ViewChild("nombre")
  referenciaNombre!:ElementRef;
  @ViewChild("descripcion")
  referenciaDescripcion!:ElementRef;
  //Constructor
  constructor(
    private habilidadService:HabilidadesService,
    private _ruta:Router
  ) {
    this.habilidadService.getHabilidades();
    this.dataSource = habilidadService.habilidades;
  }
 
  //Metodos

  setHabilidad = (habilidad:Habilidad) => {
    this.habilidadSelecionada = habilidad;
    this.habilidadService.getHabilidades();
    this._ruta.navigate(['habilidad/list']);
  }

  deleteHabilidad = (id:number)=>{
    this.habilidadService.deleteHabilidad(id);
    this.habilidadService.getHabilidades();
    this._ruta.navigate(['habilidad/list']);
  }

  updateHabilidad = ()=>{
    //console.log(this.habilidadSelecionada);
    this.habilidadSelecionada.nombre = this.referenciaNombre.nativeElement.value;
    this.habilidadSelecionada.descripcion = this.referenciaDescripcion.nativeElement.value;
    this.habilidadService.updateHabilidad(this.habilidadSelecionada,this.habilidadSelecionada.id);
    this._ruta.navigate(['habilidad/list']);
    //this.habilidadService.updateHabilidad(this.habilidadSelecionada,this.habilidadSelecionada.id);
  }

  get habiliad(){
    return this.habilidadService.habilidad;
  }
  

  get habilidades(){
    return this.habilidadService.habilidades;
  }

}
