package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.Services.TurnoService;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnoRequestDto;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnosRespondeDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/turnos")
public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("")
    public List<TurnosRespondeDto> getTurnos(@RequestParam (required = false) Long medicoId,
                                             @RequestParam (required = false) Long pacienteId,
                                             @RequestParam (required = false) LocalDate fecha){
        System.out.println("se llama a la api");
        return turnoService.getFiltrado(medicoId,pacienteId,fecha);
    }

    @PostMapping("")
    public ResponseEntity<TurnosRespondeDto> crear(@RequestBody TurnoRequestDto request){
        System.out.printf("se llama al crear");
        return ResponseEntity.ok(turnoService.crear(request));
    }
}
