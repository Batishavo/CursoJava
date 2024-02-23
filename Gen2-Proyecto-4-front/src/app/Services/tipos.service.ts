import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environments';

@Injectable({
  providedIn: 'root'
})
export class TiposService {

  public tipos:string[] = [];

  constructor(private http:HttpClient) { }

  public getTipos(): void {
    this.http.get<string[]>(`${environment.myApi}/tipos`).subscribe(
      tipos => {
        // Actualizar los datos del elemento con las habilidades recibidas
        this.tipos = tipos;
      },
      error => {
        console.error('Error al obtener tipos:', error);
      }
    );
  }
}
