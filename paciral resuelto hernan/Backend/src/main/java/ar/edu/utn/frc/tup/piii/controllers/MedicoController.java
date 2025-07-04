package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.Services.MedicoService;
import ar.edu.utn.frc.tup.piii.dtos.common.MedicoResponseDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping()
    private List<MedicoResponseDto> getAll(){
        return medicoService.getAll();
    }
}
