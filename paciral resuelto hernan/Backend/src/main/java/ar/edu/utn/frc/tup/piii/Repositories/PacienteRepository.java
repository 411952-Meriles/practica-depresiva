package ar.edu.utn.frc.tup.piii.Repositories;

import ar.edu.utn.frc.tup.piii.Entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long> {
}
