package br.com.fiap.checkpoint3.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint3.dto.ConsultaRequestCreate;
import br.com.fiap.checkpoint3.dto.ConsultaRequestUpdate;
import br.com.fiap.checkpoint3.dto.ConsultaResponse;
import br.com.fiap.checkpoint3.model.ConsultaStatus;
import br.com.fiap.checkpoint3.repository.ConsultaRepository;
import br.com.fiap.checkpoint3.service.ConsultaService;


@RestController
@RequestMapping ("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public ResponseEntity <ConsultaResponse> createConsulta (@RequestBody ConsultaRequestCreate dto) {
        return ResponseEntity.status(201).body(new ConsultaResponse().toDto(consultaService.createConsulta(dto)));
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ConsultaResponse> getConsultaById (@PathVariable Long id) {
        return consultaService.getConsultaById(id)
        .map(consulta -> new ConsultaResponse().toDto(consulta))
        .map (ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity <List<ConsultaResponse>> getAll () {
        List <ConsultaResponse> consultas = consultaService.getAll()
        .stream()
        .map(consulta -> new ConsultaResponse().toDto(consulta))
        .collect(Collectors.toList());

        return ResponseEntity.ok(consultas);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ConsultaResponse> updateConsulta (@RequestBody ConsultaRequestUpdate dto, @PathVariable Long id) {
        return consultaService.updateConsulta(dto, id)
        .map(consulta -> new ConsultaResponse().toDto(consulta))
        .map (ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteConsulta (@PathVariable Long id) {
        if (consultaService.deleteConsultaById(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping ("query")
    public ResponseEntity <List<ConsultaResponse>> findByStatus (ConsultaStatus status) {
        List <ConsultaResponse> consultas = consultaRepository.findByStatus(status)
        .stream()
        .map(consulta -> new ConsultaResponse().toDto(consulta))
        .collect(Collectors.toList());

        return ResponseEntity.ok(consultas);
    }
}
