package ar.edu.utn.frc.tup.piii.dtos.common;

import ar.edu.utn.frc.tup.piii.Entities.TurnoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TurnosRespondeDto {
    private Long id;
    private PacienteResponseDto paciente;
    private MedicoResponseDto medico;

    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    public TurnosRespondeDto(TurnoEntity te){
        this.id=te.getId();
        this.paciente=new PacienteResponseDto(te.getPaciente());
        this.medico=new MedicoResponseDto(te.getMedico());
        this.fecha=te.getFecha();
    }
}