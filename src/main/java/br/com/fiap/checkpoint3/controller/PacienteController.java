package br.com.fiap.checkpoint3.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint3.dto.PacienteRequestCreate;
import br.com.fiap.checkpoint3.dto.PacienteRequestUpdate;
import br.com.fiap.checkpoint3.dto.PacienteResponse;
import br.com.fiap.checkpoint3.service.PacienteService;

@RestController
@RequestMapping ("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity <PacienteResponse> createPaciente (@RequestBody PacienteRequestCreate dto) {
        return ResponseEntity.status(201).body(
            new PacienteResponse().toDto(pacienteService.createPaciente(dto))
        );
    }

    @PutMapping ("/{id}")
    public ResponseEntity <PacienteResponse> updatePaciente (@RequestBody PacienteRequestUpdate dto, @PathVariable Long id) {
        return pacienteService.updatePaciente(dto, id)
        .map(updatedPaciente -> new PacienteResponse().toDto(updatedPaciente))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deletePaciente (@PathVariable Long id) {
        if (pacienteService.deletePaciente(id)) 
            return ResponseEntity.noContent().build();
        else 
            return ResponseEntity.notFound().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <PacienteResponse> getPacienteById (@PathVariable Long id) {
        return pacienteService.getPacienteById(id)
        .map(p -> new PacienteResponse().toDto(p))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping ("sort")
    public ResponseEntity <List<PacienteResponse>> getAll (Sort sort) {
        List<PacienteResponse> pacientes =
        pacienteService.getAll(sort).stream()
        .map(p -> new PacienteResponse().toDto(p))
        .collect(Collectors.toList());

        return ResponseEntity.ok(pacientes);
    }
}