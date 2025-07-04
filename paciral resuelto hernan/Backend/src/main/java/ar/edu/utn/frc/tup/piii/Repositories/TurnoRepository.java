package ar.edu.utn.frc.tup.piii.Repositories;

import ar.edu.utn.frc.tup.piii.Entities.MedicoEntity;
import ar.edu.utn.frc.tup.piii.Entities.PacienteEntity;
import ar.edu.utn.frc.tup.piii.Entities.TurnoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<TurnoEntity,Long> {
    @Query("""
    SELECT t FROM TurnoEntity t
    WHERE (:fecha IS NULL OR t.fecha = :fecha)
      AND (:pacienteId IS NULL OR t.paciente.id = :pacienteId)
      AND (:medicoId IS NULL OR t.medico.id = :medicoId)
""")
    List<TurnoEntity> findByFiltros(@Param("fecha") LocalDate fecha,
                                    @Param("pacienteId") Long pacienteId,
                                    @Param("medicoId") Long medicoId);

    Long paciente(PacienteEntity paciente);

    Long medico(MedicoEntity medico);
}
