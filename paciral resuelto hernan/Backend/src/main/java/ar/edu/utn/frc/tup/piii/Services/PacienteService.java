package ar.edu.utn.frc.tup.piii.Services;

import ar.edu.utn.frc.tup.piii.dtos.common.PacienteResponseDto;

import java.util.List;

public interface PacienteService {
    public List<PacienteResponseDto> getAll();
}
