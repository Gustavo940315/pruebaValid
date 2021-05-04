import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Respuesta } from 'src/app/interfaces/response';
import { RegistrarUsuarioService } from 'src/app/services/registrar-usuario.service';



@Component({
  selector: 'app-registros',
  templateUrl: './registros.component.html',
  styleUrls: ['./registros.component.css']
})
export class RegistrosComponent implements OnInit {

  listaUsuarios: any = [];
  usuarios: number[]= [];
  estado: string = 'Registrado'

  constructor(private registrosUsuarios: RegistrarUsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.usuariosRegistro();
  }

  usuariosRegistro(){
    this.registrosUsuarios.getUsuario().subscribe(respons => {
      this.listaUsuarios = respons.body;
      for(let i=0; i<this.usuarios.length;i++){
        if(this.listaUsuarios[this.usuarios[i]].procesado == false){
          this.estado = 'Registrado'
        }
  
        if(this.listaUsuarios[this.usuarios[i]].procesado == true){
          this.estado  ='Registrado Procesado';
        }
      }
      
    });
  }

  select(id:number){
   this.usuarios.push(id);
  }

  actualizarUsauario(){
    for(let i=0; i<this.usuarios.length;i++){
      this.registrosUsuarios.putUsuario(this.listaUsuarios[this.usuarios[i]-1]).subscribe(res => {
       console.log(res);
        if(res.statusCodeValue == 200){
          window.location.reload();
        }
      })
    }
  }

  



  

}
