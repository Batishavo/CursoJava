import { Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environments';
import { Habilidad } from '../Interfaces/Habilidad ';

@Injectable({
  providedIn: 'root'
})
export class HabilidadesService  {

  habilidad:Habilidad ={
    id:0,
    nombre:"",
    descripcion:""
  };

  habilidades:Habilidad[] = [];

  constructor(private http: HttpClient) { 
    
  }

  public getHabilidades(): void{
    //console.log(this.http.get<Habilidad[]>(`${environment.myApi}/havilidades`));
    this.http.get<Habilidad[]>(`${environment.myApi}/havilidades`).subscribe(
      habilidades => {
        // Actualizar los datos del elemento con las habilidades recibidas
        this.habilidades = habilidades;
      },
      error => {
        console.error('Error al obtener habilidades:', error);
      }
    )
    //this.habilidades.sort((a, b) => (a.nombre < b.nombre ? -1:1));
  }

  public postHabilidad(habilidad: Habilidad):void{
    //console.log(this.http.post<Habilidad>(`${environment.myApi}/havilidades`, habilidad));
    this.http.post<Habilidad>(`${environment.myApi}/havilidades`, habilidad)
      .subscribe();
    
  }

  public updateHabilidad(habilidad:Habilidad,id:number):void {
    //console.log(this.http.put<Habilidad>(`${environment.myApi}/havilidades/${habilidad.id}`, habilidad));
    this.http.put<Habilidad>(`${environment.myApi}/havilidades/actualizar/${id}`, habilidad).subscribe();
  }

  public getHabilidad(id: number): void{
    //console.log(this.http.get<Habilidad>(`${environment.myApi}/havilidades/${id}`));
    this.http.get<Habilidad>(`${environment.myApi}/havilidades/${id}`).subscribe(
      data =>{
        this.habilidad = data;
      },
      error =>{
        console.log(error);
      }
    )
  }

  public deleteHabilidad(id: number): void{
    this.http.delete(`${environment.myApi}/havilidades/elminar/${id}`).subscribe();
    
  }

}
