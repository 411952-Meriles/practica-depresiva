import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
import {PacienteResponseDto} from '../../models/paciente';
import {MedicoResponseDto} from '../../models/medico';
import {HttpClient} from '@angular/common/http';
import {ApiService} from '../../ApiService';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TurnoResponseDto} from '../../models/turno';

@Component({
  selector: 'app-appointment-filter',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  standalone:true,
  templateUrl: './appointment-filter.component.html'
})
export class AppointmentFilterComponent implements OnInit{
  pacientes:PacienteResponseDto[]=[]
  medicos:MedicoResponseDto[]=[]
  medicoId:number|string="Todos"
  pacienteId:number|string="Todos"
  fecha:string=""
  //turnos:any

  @Output() turnos = new EventEmitter<TurnoResponseDto[]>();

  private api=inject(ApiService)

  ngOnInit() {
    this.api.getMedicos().subscribe(response=>{
      this.medicos=response
    })
    this.api.getPacientes().subscribe(response=>{
      this.pacientes=response
    })
  }

  buscarConFiltros(){
    console.log("ayuda")
    this.api.getTurnosConFiltros(this.pacienteId,this.medicoId,this.fecha).subscribe(response=>{
      this.turnos.emit(response)
    })
  }
}
