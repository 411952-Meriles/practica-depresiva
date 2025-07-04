package ar.edu.utn.frc.tup.piii.dtos.common;

import ar.edu.utn.frc.tup.piii.Entities.PacienteEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteResponseDto {
    private Long id;

    @NotBlank
    @JsonProperty("nombre_completo")
    private String nombreCompleto;

    @JsonProperty("fecha_nacimiento")
    private String fechaNacimiento;

    public PacienteResponseDto(PacienteEntity pe){
        this.id= pe.getId();
        this.nombreCompleto=pe.getNombreCompleto();
        this.fechaNacimiento=pe.getFechaNacimiento();
    }
}
