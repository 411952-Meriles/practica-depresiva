package ar.edu.utn.frc.tup.piii.dtos.common;

import ar.edu.utn.frc.tup.piii.entities.MedicoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    @NotNull
    private Long id;

    @NotBlank
    @JsonProperty("nombre_completo")
    private String nombreCompleto;

    @NotBlank
    private String especialidad;

    public MedicoDTO(MedicoEntity medicoEntity) {
        this.id = medicoEntity.getId();
        this.nombreCompleto = medicoEntity.getNombreCompleto();
        this.especialidad = medicoEntity.getEspecialidad();
    }
}
