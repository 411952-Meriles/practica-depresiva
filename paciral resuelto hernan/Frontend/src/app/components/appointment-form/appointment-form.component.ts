import {Component, inject, OnInit} from '@angular/core';
import {PacienteResponseDto} from '../../models/paciente';
import {MedicoResponseDto} from '../../models/medico';
import {ApiService} from '../../ApiService';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-appointment-form',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './appointment-form.component.html',
  standalone:true,
})
export class AppointmentFormComponent implements  OnInit{
  pacientes:PacienteResponseDto[]=[]
  medicos:MedicoResponseDto[]=[]
  idPaciente:number=0
  idMedico:number=0
  fecha:string="";

  private apiService=inject(ApiService)

  ngOnInit() {
    this.apiService.getMedicos().subscribe(response=>{
      this.medicos=response
    })
    this.apiService.getPacientes().subscribe(response=>{
      this.pacientes=response;
    })
  }

  crearTurno(){
    this.apiService.postTurno(this.idPaciente,this.idMedico,this.fecha!).subscribe(response=>{
      console.log(response)
    })
  }
}
