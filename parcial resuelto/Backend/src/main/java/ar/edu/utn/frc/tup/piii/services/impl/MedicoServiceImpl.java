package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.dtos.common.MedicoDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.PacienteDTO;
import ar.edu.utn.frc.tup.piii.entities.MedicoEntity;
import ar.edu.utn.frc.tup.piii.entities.PacienteEntity;
import ar.edu.utn.frc.tup.piii.exception.BusinessError;
import ar.edu.utn.frc.tup.piii.repositories.MedicoRepository;
import ar.edu.utn.frc.tup.piii.services.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<MedicoDTO> getAll() {
        List<MedicoEntity> list = medicoRepository.findAll();

        List<MedicoDTO> listDTO = new ArrayList<>();

        for (MedicoEntity medicoEntity : list) {
            listDTO.add(new MedicoDTO(medicoEntity));
        }

        return listDTO;
    }

    @Override
    public MedicoDTO getById(Long id) {
        Optional<MedicoEntity> medicoEntity = medicoRepository.findById(id);

//        if (medicoEntity.isPresent()) {
//            throw new BusinessError(HttpStatus.NOT_FOUND,
//                    "El medico no existe");
//        }

        return new MedicoDTO(medicoEntity.get());
    }
}
