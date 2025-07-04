import {Component, inject, Input, OnChanges, OnInit, SimpleChange, SimpleChanges} from '@angular/core';
import {TurnoResponseDto} from '../../models/turno';
import {ApiService} from '../../ApiService';

@Component({
  selector: 'app-appointment-list',
  imports: [],
  templateUrl: './appointment-list.component.html',
  standalone:true,
})
export class AppointmentListComponent implements OnInit,OnChanges{
  @Input() turnos:TurnoResponseDto[]=[]

  private apiService=inject(ApiService)

  ngOnInit() {
    this.apiService.getTurnos().subscribe(response=>{
      this.turnos=response
    })
  }
  ngOnChanges(changes: SimpleChanges) {
    console.log("upa")
    if(changes['turnos'])
      this.turnos=changes['turnos'].currentValue
  }

}
