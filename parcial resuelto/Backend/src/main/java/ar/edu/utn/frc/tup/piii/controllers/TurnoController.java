package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.dtos.common.CreacionTurnoDTO;
import ar.edu.utn.frc.tup.piii.dtos.common.TurnoDTO;
import ar.edu.utn.frc.tup.piii.services.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
@CrossOrigin("*")
public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("")
    public ResponseEntity<List<TurnoDTO>> getAll(
            @RequestParam(required = false) LocalDate fecha,
            @RequestParam(required = false, name = "medico_id") Long medicoId,
            @RequestParam(required = false, name = "paciente_id") Long pacienteId
    ) {
        return ResponseEntity.ok(turnoService.getAll(medicoId, pacienteId, fecha));
    }

    @PostMapping("")
    public ResponseEntity<TurnoDTO> create(@RequestBody CreacionTurnoDTO turnoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.create(turnoDTO));
    }
}
