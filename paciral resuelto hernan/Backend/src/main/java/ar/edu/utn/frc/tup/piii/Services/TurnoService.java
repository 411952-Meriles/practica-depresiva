package ar.edu.utn.frc.tup.piii.Services;

import ar.edu.utn.frc.tup.piii.dtos.common.TurnoRequestDto;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnosRespondeDto;

import java.time.LocalDate;
import java.util.List;

public interface TurnoService {
    public List<TurnosRespondeDto> getFiltrado(Long pacienteId,Long medicoId, LocalDate fecha);

    public TurnosRespondeDto crear(TurnoRequestDto dto);
}
