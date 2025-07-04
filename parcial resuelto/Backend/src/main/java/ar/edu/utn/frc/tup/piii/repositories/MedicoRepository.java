package ar.edu.utn.frc.tup.piii.repositories;

import ar.edu.utn.frc.tup.piii.dtos.common.MedicoDTO;
import ar.edu.utn.frc.tup.piii.entities.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
