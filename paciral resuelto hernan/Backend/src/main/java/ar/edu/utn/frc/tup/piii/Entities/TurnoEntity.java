package ar.edu.utn.frc.tup.piii.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="turnos")
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PacienteEntity paciente;

    @ManyToOne
    private MedicoEntity medico;

    @Column(name="FECHA_TURNO")
    private LocalDate fecha;

    private String observaciones;
}