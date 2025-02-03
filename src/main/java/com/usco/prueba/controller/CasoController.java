package com.usco.prueba.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usco.prueba.dto.CasoRequestDTO;
import com.usco.prueba.entity.Caso;
import com.usco.prueba.service.CasoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/casos")
@RequiredArgsConstructor
public class CasoController {
    private final CasoService casoService;

    // 1. Registrar una solicitud de caso
    @PostMapping("/registrar")
    public ResponseEntity<Caso> registrarCaso(@RequestBody CasoRequestDTO request) {
        Caso caso = casoService.registrarCaso(request.getUsuarioId(), request.getTipo(), request.getDescripcion());
        return ResponseEntity.ok(caso);
    }

    // 2. Asignar un caso a un estudiante
    @PutMapping("/{casoId}/asignar")
    public ResponseEntity<Caso> asignarCaso(@PathVariable Long casoId, @RequestParam String estudiante) {
        Caso caso = casoService.asignarCaso(casoId, estudiante);
        return ResponseEntity.ok(caso);
    }

    // 3. Actualizar el estado de un caso
    @PutMapping("/{casoId}/estado")
    public ResponseEntity<Caso> actualizarEstado(@PathVariable Long casoId, @RequestParam String estado) {
        Caso caso = casoService.actualizarEstado(casoId, estado);
        return ResponseEntity.ok(caso);
    }

    // 4. Consultar los casos asignados a un estudiante
    @GetMapping("/asignados")
    public ResponseEntity<List<Caso>> obtenerCasosPorEstudiante(@RequestParam String estudiante) {
        List<Caso> casos = casoService.obtenerCasosPorEstudiante(estudiante);
        return ResponseEntity.ok(casos);
    }
}
