import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Sucursal } from '../models/sucursal.model';

@Injectable({
  providedIn: 'root'
})

export class SucursalService {

  private url: string = "http://localhost:9000/sucursal";

  constructor( private http: HttpClient ) { }

  // Obtener todas las sucursales
  getAll(): Observable<Sucursal[]>{
    return this.http.get<Sucursal[]>(this.url + '/getAll');
  }

  // Obtener una sucursal
  getOne(id: any): Observable<Sucursal>{
    return this.http.get<Sucursal>(this.url + '/getOne/' + id);
  }

  // Añadir sucursal
  add(data: any): Observable<Sucursal>{
    return this.http.post<Sucursal>(this.url + '/add', data);
  }

  // Borrar sucursal
  delete(id: any): Observable<any>{
    return this.http.delete(this.url + '/delete/' + id);
  } 

  // Actualizar sucursal
  update(data: any): Observable<any>{
    return this.http.put(this.url + '/update', data);
  }


}
