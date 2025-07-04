import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AppointmentFilterComponent } from './components/appointment-filter/appointment-filter.component';
import { AppointmentListComponent } from './components/appointment-list/appointment-list.component';
import { AppointmentFormComponent } from "./components/appointment-form/appointment-form.component";
import { Filters } from './core/types/Filters';

@Component({
  selector: 'app-root',
  imports: [AppointmentFilterComponent, AppointmentListComponent, AppointmentFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend';
    newSearchParams: URLSearchParams = new URLSearchParams()

  onFiltersChange(event: Filters) {
        const filters = event
        this.newSearchParams = new URLSearchParams(filters as Record<string, string>)
    }
}
