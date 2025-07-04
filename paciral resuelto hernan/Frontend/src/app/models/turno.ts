import {PacienteResponseDto} from './paciente';
import {MedicoResponseDto} from './medico';

export interface TurnoResponseDto {
  id:number
  paciente:PacienteResponseDto
  medico:MedicoResponseDto
  fecha:string
}
