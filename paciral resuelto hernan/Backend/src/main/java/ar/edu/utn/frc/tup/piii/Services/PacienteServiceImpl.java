package ar.edu.utn.frc.tup.piii.Services;

import ar.edu.utn.frc.tup.piii.Entities.PacienteEntity;
import ar.edu.utn.frc.tup.piii.Repositories.PacienteRepository;
import ar.edu.utn.frc.tup.piii.dtos.common.PacienteResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{
    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<PacienteResponseDto> getAll() {
        List<PacienteEntity> pacienteEntities=pacienteRepository.findAll();
        List<PacienteResponseDto> pacientesDto=new ArrayList<>();
        for(PacienteEntity pe:pacienteEntities){
            pacientesDto.add(new PacienteResponseDto(pe));
        }
        return pacientesDto;
    }
}
