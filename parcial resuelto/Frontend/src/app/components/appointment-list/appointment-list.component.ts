import { Component, inject, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { TurnoDTO } from '../../core/dtos/api';
import { Filters } from '../../core/types/Filters';

@Component({
  selector: 'app-appointment-list',
  imports: [],
  templateUrl: './appointment-list.component.html'
})
export class AppointmentListComponent implements OnInit, OnChanges {
    httpClient = inject(ApiService)
    turnos: TurnoDTO[] = []
    @Input() customSearchParams: URLSearchParams = new URLSearchParams();

    ngOnChanges(changes: SimpleChanges): void {
        
        if (changes["customSearchParams"]) {
            this.fetchTurnos()
        }
    }

    ngOnInit(): void {
        this.fetchTurnos()
    }

    fetchTurnos() {
        let filtrosLimpios = new URLSearchParams();

        for (const key of this.customSearchParams.keys()) {
            const value = this.customSearchParams.get(key)

            if (value !== "undefined" && value !== "null" && value !== "NaN" && value) {
                filtrosLimpios.append(key, value)
            }
        }

        this.httpClient.getTurnos(filtrosLimpios).subscribe({
            next: (data) => {
                this.turnos = data as TurnoDTO[]
            },
            error: (err) => console.error(err)
        })
    }

}
