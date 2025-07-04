import { Component, EventEmitter, inject, OnInit, Output } from '@angular/core';
import { MedicoDTO, PacienteDTO } from '../../core/dtos/api';
import { ApiService } from '../../core/services/api.service';
import { Filters } from '../../core/types/Filters';

@Component({
  selector: 'app-appointment-filter',
  imports: [],
  templateUrl: './appointment-filter.component.html'
})
export class AppointmentFilterComponent implements OnInit {
    private httpService = inject(ApiService);
    medicos: MedicoDTO[] = []
    pacientes: PacienteDTO[] = []
    medico_id?: string;
    paciente_id?: string;
    fecha?: String;

    //Event emitter para el cambio de los filtros
    @Output() filtrosChange = new EventEmitter<Filters>()

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

    onMedicoChange(event: Event) {
        const selected = event.target as HTMLSelectElement
        if (selected.value !== "Todos") {
            this.medico_id = selected.value
        }
    }

    onPacienteChange(event: Event) {
        const selected = event.target as HTMLSelectElement
        if (selected.value !== "Todos") {
            this.paciente_id = selected.value
        }
    }

    onFechaChange(event: Event) {
        const selected = event.target as HTMLSelectElement

        this.fecha = new Date(selected.value).toISOString().split("T")[0]
    }

    onSubmit(event: Event) {
        event.preventDefault()
        this.filtrosChange.emit({medico_id: this.medico_id, paciente_id: this.paciente_id, fecha: this.fecha} as Filters)
    }
}
