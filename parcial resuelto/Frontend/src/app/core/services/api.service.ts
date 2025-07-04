import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { API } from '../config/API';
import { CrearTurnoDTO } from '../dtos/api';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
    private http = inject(HttpClient)
    constructor() { }

    public getMedicos() {
        return this.http.get(`${API.URL}/medicos`)
    }

    public getPacientes() {
        return this.http.get(`${API.URL}/pacientes`)
    }

    public getTurnos(searchParams?: URLSearchParams) {
        return this.http.get(`${API.URL}/turnos?${searchParams?.toString()}`)
    }

    public postTurnos(turnoDTO: CrearTurnoDTO) {
        return this.http.post(`${API.URL}/turnos`, turnoDTO)
    }
}
