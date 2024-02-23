import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movimiento } from '../Interfaces/Movimiento';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environments';
import { response } from 'express';

@Injectable({
  providedIn: 'root'
})
export class MovimientosService {

  movimietno!:Movimiento;

  constructor(private http:HttpClient) { }

  public getMovimientos(): Observable<Movimiento[]> {
    return this.http.get<Movimiento[]>(`${environment.myApi}/movimientos`);
  }

  public postMovimiento(movimiento: Movimiento): void{
    this.http.post<Movimiento>(`${environment.myApi}/movimientos`, movimiento).subscribe();
  }

  public updateMovimiento(movimiento:Movimiento,id:number):void {
    this.http.put<Movimiento>(`${environment.myApi}/movimientos/actualizar/${id}`,movimiento).subscribe();
  }

  public getMoviemientoById(id:number):void{
    this.http.get<Movimiento>(`${environment.myApi}/movimientos/${id}`).subscribe(
      data =>{
        this.movimietno = data;
      },
      error =>{
        console.log(error);
      }
    )
  }

  public deleteMovimiento(id: number): void{
    this.http.delete(`${environment.myApi}/movimientos/eliminar/${id}`).subscribe(
      response =>{
        console.log(response);
      }
    );
  }
}
