package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.dtos.common.CreacionTurnoDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TurnoService {

    List<TurnoDTO> getAll(Long medicoId, Long paciente_id, LocalDate fechaTurno);

    TurnoDTO create(CreacionTurnoDTO turnoDTO);
}
