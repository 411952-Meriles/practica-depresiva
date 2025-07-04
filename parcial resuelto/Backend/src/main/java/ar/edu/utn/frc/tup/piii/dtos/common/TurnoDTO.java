package ar.edu.utn.frc.tup.piii.dtos.common;

import ar.edu.utn.frc.tup.piii.entities.PacienteEntity;
import ar.edu.utn.frc.tup.piii.entities.TurnoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {
    private Long id;

    private PacienteDTO paciente;

    private MedicoDTO medico;

    @JsonProperty("fecha")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate fechaTurno;

    public TurnoDTO(TurnoEntity turnoEntity) {
        this.id = turnoEntity.getId();
        this.paciente = new PacienteDTO(turnoEntity.getPaciente());
        this.medico = new MedicoDTO(turnoEntity.getMedico());
        this.fechaTurno = turnoEntity.getFechaTurno();
    }
}
