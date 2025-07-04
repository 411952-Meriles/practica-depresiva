package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.dtos.common.ErrorApi;
import ar.edu.utn.frc.tup.piii.dtos.common.PacienteDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnoDTO;
import ar.edu.utn.frc.tup.piii.entities.PacienteEntity;
import ar.edu.utn.frc.tup.piii.entities.TurnoEntity;
import ar.edu.utn.frc.tup.piii.exception.BusinessError;
import ar.edu.utn.frc.tup.piii.repositories.PacienteRepository;
import ar.edu.utn.frc.tup.piii.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacienteRepository;

    public  PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<PacienteDTO> getAll() {
        List<PacienteEntity> list = pacienteRepository.findAll();

        List<PacienteDTO> listDTO = new ArrayList<>();

        for (PacienteEntity pacienteEntity : list) {
            listDTO.add(new PacienteDTO(pacienteEntity));
        }

        return listDTO;
    }

    @Override
    public PacienteDTO getById(Long id) {
        System.out.println("ID PACIENTE: "+ id);

        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(id);

//        if (pacienteEntity.isPresent()) {
//            throw new BusinessError(HttpStatus.NOT_FOUND,
//                    "El paciente no existe");
//        }

        return new PacienteDTO(pacienteEntity.get());
    }
}
