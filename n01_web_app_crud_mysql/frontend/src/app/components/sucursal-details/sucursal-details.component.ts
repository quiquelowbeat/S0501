import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Sucursal } from '../../models/sucursal.model';
import { SucursalService } from '../../services/sucursal.service';

@Component({
  selector: 'app-sucursal-details',
  templateUrl: './sucursal-details.component.html',
  styleUrls: ['./sucursal-details.component.css']
})
export class SucursalDetailsComponent implements OnInit {

  @Input() viewMode = false;
  @Input() currentSucursal: Sucursal = {
    nomSucursal: '',
    paisSucursal: '',
  }
  message = '';

  constructor(
    private sucursalService: SucursalService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    if(!this.viewMode){
      this.message = '';
      this.getSucursal(this.route.snapshot.params['id']);
    }
  }

  getSucursal(id: any): void {
    this.sucursalService.getOne(id).subscribe({
      next: (data) => {
        this.currentSucursal = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  updateSucursal(): void {
    this.message = '';
    this.sucursalService.update(this.currentSucursal)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = 'Sucursal editada correctament!';
        },
        error: (e) => console.error(e)
      })
  }

  deleteSucursal(): void {
    this.message = '';
    this.sucursalService.delete(this.currentSucursal.pk_SucursalID)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/sucursal/getAll']);
          this.message = 'Sucursal esborrada correctament!';
        },
        error: (e) => console.error(e)
      })
  }

}
