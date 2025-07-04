package ar.edu.utn.frc.tup.piii.Services;

import ar.edu.utn.frc.tup.piii.Entities.MedicoEntity;
import ar.edu.utn.frc.tup.piii.Entities.PacienteEntity;
import ar.edu.utn.frc.tup.piii.Entities.TurnoEntity;
import ar.edu.utn.frc.tup.piii.Repositories.MedicoRepository;
import ar.edu.utn.frc.tup.piii.Repositories.PacienteRepository;
import ar.edu.utn.frc.tup.piii.Repositories.TurnoRepository;
import ar.edu.utn.frc.tup.piii.dtos.common.BusinessException;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnoRequestDto;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnosRespondeDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService{
    private final TurnoRepository turnoRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public TurnoServiceImpl(TurnoRepository turnoRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.turnoRepository = turnoRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<TurnosRespondeDto> getFiltrado(Long pacienteId,Long medicoId, LocalDate fecha) {

        List<TurnoEntity> turnosEntities=turnoRepository.findByFiltros(fecha,pacienteId,medicoId);
        List<TurnosRespondeDto> turnosDto=new ArrayList<>();
        for(TurnoEntity te:turnosEntities){
            turnosDto.add(new TurnosRespondeDto(te));
        }
        return turnosDto;
    }

    public TurnosRespondeDto crear(TurnoRequestDto request){
        PacienteEntity paciente=pacienteRepository.findById(request.getIdPaciente()).orElseThrow(()->
                new BusinessException(HttpStatus.NOT_FOUND,"Paciente no encontrado."));

        MedicoEntity medico=medicoRepository.findById(request.getIdMedico()).orElseThrow(()->
                new BusinessException(HttpStatus.NOT_FOUND,"Medico no encontrado"));

        if(LocalDate.now().isAfter(request.getFecha())){
            throw new BusinessException(HttpStatus.BAD_REQUEST,"la fecha del turno no puede ser anterior a la actual");
        }

        TurnoEntity turnoEntity=new TurnoEntity();
        turnoEntity.setMedico(medico);
        turnoEntity.setPaciente(paciente);
        turnoEntity.setFecha(request.getFecha());
        return new TurnosRespondeDto(turnoRepository.save(turnoEntity)) ;


    }
}
