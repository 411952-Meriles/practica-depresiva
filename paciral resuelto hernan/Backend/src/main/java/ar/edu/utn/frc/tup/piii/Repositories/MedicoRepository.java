package ar.edu.utn.frc.tup.piii.Repositories;

import ar.edu.utn.frc.tup.piii.Entities.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity,Long> {
}
