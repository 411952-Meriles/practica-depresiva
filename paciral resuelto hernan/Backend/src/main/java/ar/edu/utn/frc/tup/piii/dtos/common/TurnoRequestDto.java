package ar.edu.utn.frc.tup.piii.dtos.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoRequestDto {
    @JsonProperty("paciente_id")
    private Long idPaciente;
    @JsonProperty("medico_id")
    private Long idMedico;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate fecha;
}
