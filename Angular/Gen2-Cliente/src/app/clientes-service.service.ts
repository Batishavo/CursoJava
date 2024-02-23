import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { subscribe } from 'diagnostics_channel';
import { response } from 'express';

@Injectable({
  providedIn: 'root'
})
export class ClientesServiceService {

  public listaClientes:any[];
  public urlServidor : string = "http://localhost:8082/";
  public cliente:any;

  constructor(private http: HttpClient) {
    this.listaClientes = [];
  }

  public obtenerListaClientes():void{
    //todo: hace la peticion a la api;
    this.http.get(this.urlServidor + "api/clientes")
      .subscribe((response:any) => {
      //console.log(response);
      this.listaClientes = response;
    })
  }

  guardarCliente(
    nombre:string,
    apPat:string,
    apMat:string,
    telefono:string,
    correo:string,
    numAfiliado:string
  ){
    this.http.post(this.urlServidor + "api/clientes",{
      "nombre":nombre,
      "apPaterno":apPat,
      "apMaterno":apMat,
      "telefono":telefono,
      "correo":correo,
      "numAfiliado":numAfiliado
    },).subscribe((response:any)=>{
      console.log(response.msg);
    });
  }

  //metodo que realiza una peticion get a la api para recuperar un cliente por id
  obtenerCliente(id:number):void {
    this.http.get(this.urlServidor + "api/clientes/obtener/"+id).subscribe((response:any)=>{
      //console.log(response,'si jalllllla');
      this.cliente = response;
    })
  }

  eliminarCliente(id:number):void {
    const parametrosPeticion = new HttpParams()
      .set('id',id)
      this.http.delete(this.urlServidor + 'api/clientes/eliminar',{params:parametrosPeticion}).subscribe(
        (response:any)=>{
          console.log(response);
          this.obtenerListaClientes();
    })
  }

  actualizarCliente(id:number,nombre:string,apPat:string,apMat:string,telefono:string,correo:string,numAgiliado:string) 
  {
    this.http.put(this.urlServidor+"api/clientes/actualizar/"+id,{
      "id":id,
      "nombre":nombre,
      "apPaterno":apPat,
      "apMaterno":apMat,
      "telefono":telefono,
      "correo":correo,
      "numAfiliado":numAgiliado
    },).subscribe((response:any) =>{
      console.log(response.msg);
    });
  }

  
}
