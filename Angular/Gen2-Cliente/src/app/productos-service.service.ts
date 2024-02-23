import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ProductosServiceService {
  
  public listaProductps:any[] = [];
  public listaCategorias:any[] = [];
  public urlServidor : string = "http://localhost:8082/";
  public clientes: any;

  constructor(private http: HttpClient) {
    this.listaProductps = [];
  }

  obtenerListaProductos():void{
    this.http.get(this.urlServidor+"api/productos")
    .subscribe((response:any)=>{
      this.listaProductps = response;
    }
  )}

  obtenerCategoria():void{
    this.http.get(this.urlServidor+"api/productos/categorias")
    .subscribe((response:any)=>{
      console.log(response);
      this.listaCategorias = response;
    }
  )}

  guardarProducto(
    nombre:string,
    descripcion:string,
    stock:number,
    precio:number,
    categoria:string
  ){
    this.http.post(this.urlServidor+"api/productos",{
      "nombre": nombre,
      "descripcion": descripcion,
      "stock": stock,
      "precio": precio,
      "categoria": categoria
    },).subscribe((response:any)=>{
      console.log(response.msg);
    });
  }
}
