package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.dtos.common.CreacionTurnoDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.MedicoDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.PacienteDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnoDTO;
import ar.edu.utn.frc.tup.piii.entities.MedicoEntity;
import ar.edu.utn.frc.tup.piii.entities.PacienteEntity;
import ar.edu.utn.frc.tup.piii.entities.TurnoEntity;
import ar.edu.utn.frc.tup.piii.repositories.TurnoRepository;
import ar.edu.utn.frc.tup.piii.services.MedicoService;
import ar.edu.utn.frc.tup.piii.services.PacienteService;
import ar.edu.utn.frc.tup.piii.services.TurnoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {
    private final TurnoRepository turnoRepository;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public TurnoServiceImpl(TurnoRepository turnoRepository, MedicoService medicoService, PacienteService pacienteService) {
        this.turnoRepository = turnoRepository;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    @Override
    public List<TurnoDTO> getAll(Long medicoId, Long pacienteId, LocalDate fechaTurno) {
        List<TurnoEntity> listEntity = turnoRepository.findFiltered(fechaTurno, medicoId, pacienteId);

        List<TurnoDTO> listDTO = new ArrayList<>();

        for (TurnoEntity turnoEntity : listEntity) {
            listDTO.add(new TurnoDTO(turnoEntity));
        }

        return listDTO;
    }

    @Override
    public TurnoDTO create(CreacionTurnoDTO turnoDTO) {
        TurnoEntity turnoEntity = new TurnoEntity();

        turnoEntity.setFechaTurno(turnoDTO.getFecha());

        MedicoDTO medicoDTO = medicoService.getById(turnoDTO.getMedicoId());
        MedicoEntity medicoEntity = new MedicoEntity();

        medicoEntity.setId(medicoDTO.getId());
        medicoEntity.setEspecialidad(medicoDTO.getEspecialidad());
        medicoEntity.setNombreCompleto(medicoDTO.getNombreCompleto());

        turnoEntity.setMedico(medicoEntity);

        PacienteDTO pacienteDTO = pacienteService.getById(turnoDTO.getPacienteId());
        PacienteEntity pacienteEntity = new PacienteEntity();

        pacienteEntity.setId(pacienteDTO.getId());
        pacienteEntity.setNombreCompleto(pacienteDTO.getNombreCompleto());
        pacienteEntity.setFechaNacimiento(pacienteDTO.getFechaNacimiento());

        turnoEntity.setPaciente(pacienteEntity);

        turnoEntity.setObservaciones(turnoDTO.getObservaciones());

        return new TurnoDTO(turnoRepository.save(turnoEntity));
    }
}
