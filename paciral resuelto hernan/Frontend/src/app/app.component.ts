import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {AppointmentFilterComponent} from './components/appointment-filter/appointment-filter.component';
import {AppointmentListComponent} from './components/appointment-list/appointment-list.component';
import {TurnoResponseDto} from './models/turno';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    AppointmentFilterComponent,
    AppointmentListComponent,
    RouterLink
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend';
  turnosParaList:TurnoResponseDto[]=[]

  onTurnosRecibidos(turnos:TurnoResponseDto[]){
    this.turnosParaList=[...turnos]
  }

}
