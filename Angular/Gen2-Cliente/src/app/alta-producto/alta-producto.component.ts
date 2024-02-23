import { Component, ElementRef, ViewChild } from '@angular/core';
import { Router, RouterModule} from '@angular/router';
import { CommonModule } from '@angular/common';
import { ProductosServiceService } from '../productos-service.service';


@Component({
  selector: 'app-alta-producto',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './alta-producto.component.html',
  styleUrl: './alta-producto.component.css'
})
export class AltaProductoComponent {
  
  constructor(
    public servicio : ProductosServiceService,
    public router:Router
  ){
    console.log("CONTRUCTOR", this.servicio.listaCategorias); 
    this.servicio.obtenerCategoria();    
  }

  //atributos
  @ViewChild("nombre")
  referenciaNombre!: ElementRef;

  @ViewChild("descripcion")
  referenciaDescripcion!: ElementRef;

  @ViewChild("precio")
  referenciaprecio!: ElementRef;

  @ViewChild("stock")
  referenciaStock!: ElementRef;

  @ViewChild("categoria")
  refeferenciaCategoria!: ElementRef;

  get categorias(){
    console.log(this.servicio.listaCategorias);
    return this.servicio.listaCategorias;
  }


  gurardarProduct(){
    const nombre = this.referenciaNombre.nativeElement.value;
    const descripcion = this.referenciaDescripcion.nativeElement.value;
    const precio = this.referenciaprecio.nativeElement.value;
    const stock = this.referenciaStock.nativeElement.value;
    const categoria = this.refeferenciaCategoria.nativeElement.value;

    this.servicio.guardarProducto(nombre,descripcion,precio,stock,categoria);
    this.router.navigate(["productos"])
  }


  


}
