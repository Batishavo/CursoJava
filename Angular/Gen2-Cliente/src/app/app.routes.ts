import { Routes } from '@angular/router';
import { ListadoClientesComponent } from './listado-clientes/listado-clientes.component';
import { AltaClienteComponent } from './alta-cliente/alta-cliente.component';
import { ListadoProductosComponent } from './listado-productos/listado-productos.component';
import { AltaProductoComponent } from './alta-producto/alta-producto.component';
import { DetalleClienteComponent } from './detalle-cliente/detalle-cliente.component';
import { EdicionClienteComponent } from './edicion-cliente/edicion-cliente.component';
import { DetalleVentaComponent } from './detalle-venta/detalle-venta.component';
import { VentasComponent } from './ventas/ventas.component';

export const routes: Routes = [
    {path:"clientes", component:ListadoClientesComponent},
    {path:"clietes/alta",component:AltaClienteComponent},
    {path:"productos",component:ListadoProductosComponent},
    {path:"productos/alta",component:AltaProductoComponent},
    {path:"cliente/detalle/:id",component:DetalleClienteComponent},
    {path:"cliente/editar/:id",component:EdicionClienteComponent},
    {path:"cliente/detalleventa/:id",component:DetalleVentaComponent},
    {path:"ventas",component:VentasComponent},
    {path:"",redirectTo:"/clientes",pathMatch:"full"}
];
