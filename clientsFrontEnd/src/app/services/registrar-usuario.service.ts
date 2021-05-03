import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Respuesta, Body } from '../interfaces/response';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrarUsuarioService {

url: string = 'http://localhost:8080/clients/v1/clients/save';

  constructor(private http: HttpClient) { }

  postUsuario(usuario: Body): Observable<Respuesta>{
    return this.http.post<Respuesta>(this.url, usuario);
  }
}
