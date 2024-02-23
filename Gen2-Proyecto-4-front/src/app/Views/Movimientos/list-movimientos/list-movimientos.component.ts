import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MovimientosService } from '../../../Services/movimientos.service';
import { Movimiento } from '../../../Interfaces/Movimiento';
import { TiposService } from '../../../Services/tipos.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list-movimientos',
  templateUrl: './list-movimientos.component.html',
  styleUrl: './list-movimientos.component.css'
})
export class ListMovimientosComponent implements OnInit {
  
  //Atributos

  ELEMENT_DATA :Movimiento[] = [];
  movimiento:Movimiento = {
    id: 0,
    nombre: '',
    tipo: '',
    descipcion: '',
    poder: 0,
    precision: 0,
    pp: 0
  }
  displayedColumns: string[] = ['id','nombre',"tipo","detalle","editar","eliminar"];
  movimientoColums:string[] =['Dato','Valor'];
  dataSource = this.ELEMENT_DATA;
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

  //Constuctor
  constructor(
    private _ruta: Router,
    private movimientoService:MovimientosService,
    private tiposService:TiposService,
  ){
    this.tiposService.getTipos();
  }
  
  
  ngOnInit(): void {
    
    this.movimientoService.getMovimientos().subscribe(
      movimientos => {
        this.ELEMENT_DATA = movimientos;
      },
      error=>{
        console.error('Error al obtener movimientos:', error);
      }
    );
    this.dataSource = this.ELEMENT_DATA;

  }

  
  get tipos(){
    return this.tiposService.tipos;
  }

  setMovimiento = (id:number) => {
    const movimientoEncontrado = this.ELEMENT_DATA.find(e => e.id === id);
    if(movimientoEncontrado!== undefined){
      this.movimiento = movimientoEncontrado;
    }else{
      console.log("No funciona");
    }
  }

  limpiar = () => {
    this.referenciaNombre.nativeElement.value = "";
    this.referenciaDescripcion.nativeElement.value = "";
    this.referenciaPoder.nativeElement.value = "";
    this.referenciaPrecision.nativeElement.value = "";
    this.referenciaPP.nativeElement.value = "";
  }

  updateMovimiento=()=>{
    this.movimiento.nombre = this.referenciaNombre.nativeElement.value;
    this.movimiento.descipcion = this.referenciaDescripcion.nativeElement.value;
    this.movimiento.poder = this.referenciaPoder.nativeElement.value;
    this.movimiento.precision = this.referenciaPrecision.nativeElement.value;
    this.movimiento.pp = this.referenciaPP.nativeElement.value;
    //console.log(this.movimiento);
    this.movimientoService.updateMovimiento(this.movimiento, this.movimiento.id);
    this._ruta.navigate(['movimientos/list']);
  }

  deleteMovimiento(id: number): void{
    //console.log(id);
    this.movimientoService.deleteMovimiento(id);
    this._ruta.navigate(['movimientos/list']);
  }
}
