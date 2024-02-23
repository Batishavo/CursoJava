import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ListadoClientesComponent } from './listado-clientes/listado-clientes.component';
import { FooterComponent } from './footer/footer.component';
import { ListadoProductosComponent } from './listado-productos/listado-productos.component';
import { AltaClienteComponent } from './alta-cliente/alta-cliente.component';
import { AltaProductoComponent } from './alta-producto/alta-producto.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    NavBarComponent,
    ListadoClientesComponent,
    FooterComponent,
    ListadoProductosComponent,
    AltaClienteComponent,
    AltaProductoComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Gen2-Cliente';
}
