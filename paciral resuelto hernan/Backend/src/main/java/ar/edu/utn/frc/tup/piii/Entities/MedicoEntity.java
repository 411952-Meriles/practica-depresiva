package ar.edu.utn.frc.tup.piii.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="medicos")
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    private String especialidad;

    @JoinColumn(name="id_turno")
    @OneToMany
    private List<TurnoEntity> turnos;
}