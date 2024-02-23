import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderModule } from './header/header.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    FooterComponent,
  ],
  imports: [
    CommonModule,
    HeaderModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
  ]
})
export class ComponetModule { }
