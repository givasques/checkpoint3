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

import br.com.fiap.checkpoint3.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint3.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint3.dto.ProfissionalResponse;
import br.com.fiap.checkpoint3.service.ProfissionalService;

@RestController
@RequestMapping ("profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;
    
    @PostMapping
    public ResponseEntity <ProfissionalResponse> createProfissional (@RequestBody ProfissionalRequestCreate dto) {
        return ResponseEntity.status(201).body(
            new ProfissionalResponse().toDto(profissionalService.createProfissional(dto))
        );
    }

    @PutMapping ("/{id}")
    public ResponseEntity <ProfissionalResponse> updateProfissional (@RequestBody ProfissionalRequestUpdate dto, @PathVariable Long id) {
        return profissionalService.updateProfissional(dto, id)
        .map(updatedProfissional -> new ProfissionalResponse().toDto(updatedProfissional))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deleteProfissional (@PathVariable Long id) {
        if (profissionalService.deleteProfissional(id)) 
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ProfissionalResponse> getProfissionalById (@PathVariable Long id) {
        return profissionalService.getProfissionalById(id)
        .map(p -> new ProfissionalResponse().toDto(p))
        .map (ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity <List<ProfissionalResponse>> getAll () {
        List <ProfissionalResponse> profissionais = profissionalService.getAll().stream()
        .map(p -> new ProfissionalResponse().toDto(p))
        .collect(Collectors.toList());

        return ResponseEntity.ok(profissionais);
    }
}