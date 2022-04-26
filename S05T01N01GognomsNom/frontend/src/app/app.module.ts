import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddSucursalComponent } from './components/add-sucursal/add-sucursal.component';
import { SucursalDetailsComponent } from './components/sucursal-details/sucursal-details.component';
import { SucursalListComponent } from './components/sucursal-list/sucursal-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddSucursalComponent,
    SucursalDetailsComponent,
    SucursalListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
