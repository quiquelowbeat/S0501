import { Component, OnInit } from '@angular/core';
import { Sucursal } from '../../models/sucursal.model';
import { SucursalService } from '../../services/sucursal.service';

@Component({
  selector: 'app-add-sucursal',
  templateUrl: './add-sucursal.component.html',
  styleUrls: ['./add-sucursal.component.css']
})
export class AddSucursalComponent implements OnInit {

  sucursal: Sucursal = {
    nomSucursal: '',
    paisSucursal: ''
  };
  submitted = false;
  
  constructor(private sucursalService: SucursalService) { }

  ngOnInit(): void {
  }

  saveSucursal(): void {
    const data = {
      nomSucursal: this.sucursal.nomSucursal,
      paisSucursal: this.sucursal.paisSucursal
    };
    if(this.sucursal.nomSucursal != '' || this.sucursal.paisSucursal != ''){
      this.submitted = true;
      this.sucursalService.add(data).subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (e) => console.error(e)
      })
    } else {
      this.submitted = false;
    }
    
  }

  newSucursal(): void {
    this.submitted = false;
    this.sucursal = {
      nomSucursal: '',
      paisSucursal: ''
    }
  }

}
