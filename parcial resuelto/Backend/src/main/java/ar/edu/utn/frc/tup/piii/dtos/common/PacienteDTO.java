package ar.edu.utn.frc.tup.piii.dtos.common;

import ar.edu.utn.frc.tup.piii.entities.MedicoEntity;
import ar.edu.utn.frc.tup.piii.entities.PacienteEntity;
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
public class PacienteDTO {
    @NotNull
    private Long id;

    @NotBlank
    @JsonProperty("nombre_completo")
    private String nombreCompleto;

    @NotBlank
    @JsonProperty("fecha_nacimiento")
    private LocalDate fechaNacimiento;

    public PacienteDTO(PacienteEntity pacienteEntity) {
        this.id = pacienteEntity.getId();
        this.nombreCompleto = pacienteEntity.getNombreCompleto();
        this.fechaNacimiento = pacienteEntity.getFechaNacimiento();
    }
}
