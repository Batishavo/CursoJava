import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientesServiceService } from '../clientes-service.service';


@Component({
  selector: 'app-edicion-cliente',
  standalone: true,
  imports: [],
  templateUrl: './edicion-cliente.component.html',
  styleUrl: './edicion-cliente.component.css'
})
export class EdicionClienteComponent {

  private params:any;
  private id:number = 0;
     //atributos
     @ViewChild("nombre")
     referenciaNombre!: ElementRef;
   
     @ViewChild("apPaterno")
     referenciapPaterno!: ElementRef;
     
     @ViewChild("apMaterno")
     referenciapMaterno!: ElementRef;
   
     @ViewChild("telefono")
     referenciatelefono!: ElementRef;
     
     @ViewChild("correo")
     referenciacorreo!: ElementRef;
   
     @ViewChild("numAfiliado")
     referenciaNumAfiliado!: ElementRef;
     constructor(
      private ruta:ActivatedRoute,
      private servicio:ClientesServiceService,
      private router:Router
    ){
      //console.log(parametros["id"]);
      this.params = this.ruta.params.subscribe(parametros =>{
        this.id = parametros["id"];
        console.log(this.id);
        this.servicio.obtenerCliente(this.id);
      })
    }
  actualizarCliente(){
    const nombre = this.referenciaNombre.nativeElement.value;
    const apPaterno = this.referenciapPaterno.nativeElement.value;
    const apMaterno = this.referenciapMaterno.nativeElement.value;
    const telefono = this.referenciatelefono.nativeElement.value;
    const correo = this.referenciacorreo.nativeElement.value;
    const numAfiliado = this.referenciaNumAfiliado.nativeElement.value;

    this.servicio.actualizarCliente(this.id,nombre,apPaterno,apMaterno,telefono,correo,numAfiliado);
    this.router.navigate(["clientes"]);
  }
  get cliente(){
    //console.log("hola");
    //console.log(this.cliente);
    return this.servicio.cliente;
  }
}
