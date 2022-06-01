import { Component, OnInit } from '@angular/core';
import { Sucursal } from '../../models/sucursal.model';
import { SucursalService } from '../../services/sucursal.service';

@Component({
  selector: 'app-sucursal-list',
  templateUrl: './sucursal-list.component.html',
  styleUrls: ['./sucursal-list.component.css']
})
export class SucursalListComponent implements OnInit {
  sucursals : string = "Llista de sucursals";

  sucursalList?: Sucursal[];
  currentSucursal: Sucursal = {};
  currentIndex = -1;
  nomSucursal = '';

  constructor(private sucursalService: SucursalService) { }

  ngOnInit(): void {
    this.retrieveSucursals();
  }

  retrieveSucursals(): void {
    this.sucursalService.getAll().subscribe({
      next: (data) => {
        this.sucursalList = data;
        console.log(data);
      }, 
      error: (e) => console.error(e)
    });
  }

  refreshList(): void{
    this.retrieveSucursals();
    this.currentSucursal = {};
    this.currentIndex = -1;
  }
  
  setActiveSucursal(sucursal: Sucursal, index: number): void {
    this.currentSucursal = sucursal;
    this.currentIndex = index;
  }
}
