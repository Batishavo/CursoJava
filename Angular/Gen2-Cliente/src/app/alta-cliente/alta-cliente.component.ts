import { CommonModule } from '@angular/common';
import { Component, ViewChild,ElementRef } from '@angular/core';
import { ClientesServiceService } from '../clientes-service.service';
import { Router, RouterModule } from '@angular/router';


@Component({
  selector: 'app-alta-cliente',
  standalone: true,
  imports: [],
  templateUrl: './alta-cliente.component.html',
  styleUrl: './alta-cliente.component.css'
})
export class AltaClienteComponent {

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
    private servicio :ClientesServiceService ,
    private router:Router 
  ){
    
  }

  guardarCliente(){
    const nombre = this.referenciaNombre.nativeElement.value;
    const apPaterno = this.referenciapPaterno.nativeElement.value;
    const apMaterno = this.referenciapMaterno.nativeElement.value;
    const telefono = this.referenciatelefono.nativeElement.value;
    const correo = this.referenciacorreo.nativeElement.value;
    const numAfiliado = this.referenciaNumAfiliado.nativeElement.value;

    this.servicio.guardarCliente(nombre,apPaterno,apMaterno,telefono,correo,numAfiliado);
    this.router.navigate(["clientes"]);
  }


}
