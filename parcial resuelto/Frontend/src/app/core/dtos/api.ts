export interface PacienteDTO {
    id: number,
    nombre_completo: string,
    fecha_nacimiento: Date
}

export interface MedicoDTO {
    id: number,
    nombre_completo: string,
    especialidad: string
}

export interface TurnoDTO {
    id: number,
    paciente: PacienteDTO,
    medico: MedicoDTO,
    fecha: Date
}

export interface CrearTurnoDTO {
    paciente_id: number,
    medico_id: number,
    fecha: String
}