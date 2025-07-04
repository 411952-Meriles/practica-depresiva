package ar.edu.utn.frc.tup.piii.Services;

import ar.edu.utn.frc.tup.piii.dtos.common.MedicoResponseDto;

import java.util.List;

public interface MedicoService {
    public List<MedicoResponseDto> getAll();
}
