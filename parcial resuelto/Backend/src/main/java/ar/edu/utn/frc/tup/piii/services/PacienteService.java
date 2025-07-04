package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.dtos.common.PacienteDTO;
import ar.edu.utn.frc.tup.piii.entities.PacienteEntity;

import java.util.List;

public interface PacienteService {
    List<PacienteDTO> getAll();

    PacienteDTO getById(Long id);
}
