import { Component, EventEmitter, inject } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { CrearTurnoDTO, MedicoDTO, PacienteDTO } from '../../core/dtos/api';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-appointment-form',
  imports: [FormsModule],
  templateUrl: './appointment-form.component.html'
})
export class AppointmentFormComponent {
private httpService = inject(ApiService);
    medicos: MedicoDTO[] = []
    pacientes: PacienteDTO[] = []
    
    formValues = {
        paciente_id: 0,
        medico_id: 0,
        fecha: ""
    }
    

    ngOnInit(): void {
        this.httpService.getMedicos().subscribe({
            next: (data) => {
                this.medicos = data as MedicoDTO[]
            },
            error: (err) => console.error(err)
        })

        this.httpService.getPacientes().subscribe({
            next: (data) => {
                this.pacientes = data as PacienteDTO[]
            },
            error: (err) => console.error(err)
        })
    }

    onSubmit(event: Event) {
        this.httpService.postTurnos({
            paciente_id: this.formValues.paciente_id, 
            medico_id: this.formValues.medico_id,

            //Crear una fecha (LocalDate) a partir de un string. Si piden hora/minutos/segundos sacar split("T")[0] (LocalDateTime)
            fecha: this.formValues.fecha.split("T")[0]} as CrearTurnoDTO)
            .subscribe({
            next: (data) => console.log(data)
        })
    }
}
