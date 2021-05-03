import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

import {  RegistrarUsuarioService } from '../../services/registrar-usuario.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  //Request
  usuario = {
    id: 1,
    nombre:'',
    apellido:'',
    procesado: false
  }

  constructor(private registrarUsario: RegistrarUsuarioService, private router: Router) { }
 
  ngOnInit(): void {
  }

  onSubmint(){
    if(0 == this.usuario.nombre.trim().length){
      Swal.fire({
        icon: 'warning',
        title: 'ALERTA',
        text: 'El campo Nombre es de caracter obligatorio',
        confirmButtonColor: 'btn-color',
        confirmButtonText: 'OK',
      });
    }
    if(0 == this.usuario.apellido.trim().length){
      Swal.fire({
        icon: 'warning',
        title: 'ALERTA',
        text: 'El campo Apellido es de caracter obligatorio',
        confirmButtonColor: 'btn-color',
        confirmButtonText: 'OK',
      });
    }
    else {
      this.registrarUsario.postUsuario(this.usuario).subscribe((data) => {
        if(data.statusCodeValue == 200){
          this.router.navigate(['registros']);
        }
      })
    }  
  }

}
