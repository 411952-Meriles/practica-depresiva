package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.dtos.common.MedicoDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.PacienteDTO;
import ar.edu.utn.frc.tup.piii.entities.MedicoEntity;

import java.util.List;

public interface MedicoService {

    List<MedicoDTO> getAll();
    MedicoDTO getById(Long id);
}
