import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddSucursalComponent } from './components/add-sucursal/add-sucursal.component';
import { SucursalListComponent } from './components/sucursal-list/sucursal-list.component';
import { SucursalDetailsComponent } from './components/sucursal-details/sucursal-details.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

const routes: Routes = [
  {path: '', redirectTo: 'sucursal/getAll', pathMatch: 'full'},
  {path: 'sucursal/add', component: AddSucursalComponent},
  {path: 'sucursal/getAll', component: SucursalListComponent},
  {path: 'sucursal/getOne/:id', component: SucursalDetailsComponent},
  // 404 - NOT FOUND
  { path: '**', pathMatch: 'full', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
