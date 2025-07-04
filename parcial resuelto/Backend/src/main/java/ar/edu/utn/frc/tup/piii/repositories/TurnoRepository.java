package ar.edu.utn.frc.tup.piii.repositories;

import ar.edu.utn.frc.tup.piii.entities.TurnoEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TurnoRepository extends JpaRepository<TurnoEntity,Long> {

    @Query("""
        SELECT t FROM TurnoEntity AS t
        WHERE (:fecha IS NULL OR t.fechaTurno = :fecha)
        AND (:pacienteId IS NULL OR t.paciente.id = :pacienteId)
        AND (:medicoId IS NULL OR t.medico.id = :medicoId)
    """)
    List<TurnoEntity> findFiltered(@Param("fecha")LocalDate fecha, @Param("pacienteId") Long pacienteId, @Param("medicoId")Long medicoId);
}
