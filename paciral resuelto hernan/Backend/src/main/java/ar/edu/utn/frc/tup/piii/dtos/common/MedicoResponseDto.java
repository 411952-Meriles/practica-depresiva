package ar.edu.utn.frc.tup.piii.dtos.common;

import ar.edu.utn.frc.tup.piii.Entities.MedicoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponseDto {

    private Long id;
    @NotBlank
    @JsonProperty("nombre_completo")
    private String nombreCompleto;

    private String especialidad;

    public MedicoResponseDto(MedicoEntity medico){
        this.id= medico.getId();
        this.nombreCompleto= medico.getNombreCompleto();
        this.especialidad= medico.getEspecialidad();
    }
}
