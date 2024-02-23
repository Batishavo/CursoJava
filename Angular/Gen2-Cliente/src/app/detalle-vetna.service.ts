import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DetalleVetnaService {

  public listDetalleVenta: any[];
  public urlSevidor : string = "http://localhost:8082/";


  constructor(
    private http: HttpClient
  ) { 
    this.listDetalleVenta = [];
  }

  public obtenerDetalleVenta(): void{
    this.http.get(this.urlSevidor + "api/ventas")
      .subscribe((response: any) => {
      //console.log(response);
      this.listDetalleVenta = response;
    })
  }
}
