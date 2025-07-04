import { Routes } from '@angular/router';
import {AppointmentListComponent} from './components/appointment-list/appointment-list.component';
import {AppointmentFormComponent} from './components/appointment-form/appointment-form.component';

export const routes: Routes = [{
  path:"",
  redirectTo:"turnos",
  pathMatch:"full"
},{
  path:"turnos",
  component:AppointmentListComponent
},{
  path:"alta-turno",
  component:AppointmentFormComponent
},{
  path:"**",
  redirectTo:"turnos",
  pathMatch:"full"
}];
