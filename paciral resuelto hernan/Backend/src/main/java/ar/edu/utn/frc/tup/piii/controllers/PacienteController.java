package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.Services.PacienteService;
import ar.edu.utn.frc.tup.piii.dtos.common.PacienteResponseDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping()
    public List<PacienteResponseDto> getAll(){
        return pacienteService.getAll();
    }
}
