package br.com.fiap.checkpoint3.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint3.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint3.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint3.model.Profissional;
import br.com.fiap.checkpoint3.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

    @Autowired
    ProfissionalRepository profissionalRepository;

    public Profissional createProfissional (ProfissionalRequestCreate dto) {
        Profissional profissional = dto.toModel();
        LocalDateTime now = LocalDateTime.now();
        profissional.setCreatedAt(now);
        profissional.setUpdatedAt(now);
        return profissionalRepository.save(profissional);
    }

    public Optional <Profissional> updateProfissional (ProfissionalRequestUpdate dto, Long id) {
        return profissionalRepository.findById(id)
        .map(p -> {
            p.setUpdatedAt(LocalDateTime.now());
            return profissionalRepository.save(dto.toModel(p));
        });
    }

    public boolean deleteProfissional (Long id) {
        if (profissionalRepository.findById(id).isPresent()) {
            profissionalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional <Profissional> getProfissionalById (Long id) {
        return profissionalRepository.findById(id);
    }

    public List <Profissional> getAll () {
        return profissionalRepository.findAll();
    }
}