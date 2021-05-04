import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Respuesta, Body } from '../interfaces/response';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrarUsuarioService {

url_1: string = 'http://localhost:8080/clients/v1/clients/all';
url_2: string = 'http://localhost:8080/clients/v1/clients/save';
url_3: string = 'http://localhost:8080/clients/v1/clients/update';


  constructor(private http: HttpClient) { }
  
  getUsuario(): Observable<Respuesta>{
    const headers = {};
    return this.http.get<Respuesta>(this.url_1, headers);
  }

  postUsuario(usuario: Body): Observable<Respuesta>{
    return this.http.post<Respuesta>(this.url_2, usuario);
  }

  putUsuario(usuario: Body): Observable<Respuesta>{
    
    return this.http.put<Respuesta>(this.url_3, usuario);
  }
}
