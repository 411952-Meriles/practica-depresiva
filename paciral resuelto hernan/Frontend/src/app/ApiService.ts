import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {TurnoResponseDto} from './models/turno';
import {PacienteResponseDto} from './models/paciente';
import {MedicoResponseDto} from './models/medico';

@Injectable({
  providedIn: 'root'
})

export class ApiService{
  baseUrl :string="http://localhost:8080/api/v1"

  private http=inject(HttpClient)



  getTurnos(){
    //console.log("llama al api service")
    return this.http.get<TurnoResponseDto[]>(this.baseUrl+"/turnos")
  }

  getTurnosConFiltros(idPaciente?: number | string, idMedico?: number | string, fecha?: string){
    let params=new HttpParams()

    if(idPaciente!=="Todos"){
      params=params.set("pacienteId",idPaciente!.toString())
    }
    if(idMedico!=="Todos"){
      params=params.set("medicoId",idMedico!.toString())
    }
    if (fecha!=="") {
      // formatea la fecha a yyyy-MM-dd
      params = params.set('fecha', fecha!.split("T")[0]);
    }

    return this.http.get<TurnoResponseDto[]>(this.baseUrl+"/turnos",{params})
  }

  getPacientes(){
    return this.http.get<PacienteResponseDto[]>(this.baseUrl+"/pacientes")
  }

  getMedicos(){
    return this.http.get<MedicoResponseDto[]>(this.baseUrl+"/medicos")
  }

  postTurno(idPaciente:number,idMedico: number,fecha:string){
    return this.http.post<TurnoResponseDto>(this.baseUrl+"/turnos",{paciente_id:idPaciente, medico_id:idMedico,fecha:fecha.split("T")[0]})
  }
}
