package ar.edu.utn.frc.tup.piii.Services;

import ar.edu.utn.frc.tup.piii.Entities.MedicoEntity;
import ar.edu.utn.frc.tup.piii.Repositories.MedicoRepository;
import ar.edu.utn.frc.tup.piii.dtos.common.MedicoResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl( MedicoRepository medicoRepository) {

        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<MedicoResponseDto> getAll() {
        List<MedicoResponseDto> medicosDto=new ArrayList<>();

        List<MedicoEntity> medicosEntitis = medicoRepository.findAll();
        for(MedicoEntity me:medicosEntitis){
            medicosDto.add(new MedicoResponseDto(me));
        }
        return medicosDto;
    }
}
