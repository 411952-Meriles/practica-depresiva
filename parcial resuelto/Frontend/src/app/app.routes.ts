import { Routes } from '@angular/router';
import { AppointmentFormComponent } from './components/appointment-form/appointment-form.component';
import { AppointmentListComponent } from './components/appointment-list/appointment-list.component';

export const routes: Routes = [
    {
        path: "turnos",
        component: AppointmentListComponent
    },
    {
        path: "alta-turno",
        component: AppointmentFormComponent
    }
];
