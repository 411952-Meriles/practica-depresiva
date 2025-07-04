package ar.edu.utn.frc.tup.piii.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="pacientes")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    private String fechaNacimiento;

    @JoinColumn(name="id_turno")
    @OneToMany
    private List<TurnoEntity> turnos;
}
