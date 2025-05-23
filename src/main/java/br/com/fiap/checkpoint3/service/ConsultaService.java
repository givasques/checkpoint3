package br.com.fiap.checkpoint3.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint3.dto.ConsultaRequestCreate;
import br.com.fiap.checkpoint3.dto.ConsultaRequestUpdate;
import br.com.fiap.checkpoint3.model.Consulta;
import br.com.fiap.checkpoint3.model.Paciente;
import br.com.fiap.checkpoint3.model.Profissional;
import br.com.fiap.checkpoint3.repository.ConsultaRepository;
import br.com.fiap.checkpoint3.repository.PacienteRepository;
import br.com.fiap.checkpoint3.repository.ProfissionalRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Consulta createConsulta (ConsultaRequestCreate dto) {
        
        Paciente paciente = pacienteRepository
        .findById(dto.getPacienteId())
        .orElseThrow(() -> {
            throw new RuntimeException("Paciente inexistente: ID " + dto.getPacienteId());
        });
        
        Profissional profissional = profissionalRepository
        .findById(dto.getProfissionalId())
        .orElseThrow(() -> {
            throw new RuntimeException("Profissional inexistente: ID " + dto.getProfissionalId());
        });

        return consultaRepository.save(dto.toModel(paciente, profissional));
    }

    public Optional<Consulta> getConsultaById (Long id) {
        return consultaRepository.findById(id);
    }

    public List <Consulta> getAll () {
        return consultaRepository.findAll();
    }

    public boolean deleteConsultaById (Long id) {
        if (consultaRepository.findById(id).isPresent()) {
            consultaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Consulta> updateConsulta (ConsultaRequestUpdate dto, Long id) {
        return consultaRepository.findById(id)
        .map(c -> {
            c.setData(dto.getData());
            c.setQuantidadeHoras(dto.getQuantidadeHoras());
            
            Paciente paciente = pacienteRepository
            .findById(dto.getPacienteId())
            .orElseThrow(() -> {
                throw new RuntimeException("Paciente inexistente: ID " + dto.getPacienteId());
            });

            Profissional profissional = profissionalRepository
            .findById(dto.getProfissionalId())
            .orElseThrow(() -> {
                throw new RuntimeException("Profissional inexistente: ID " + dto.getProfissionalId());
            });
            
            c.setPaciente(paciente);
            c.setProfissional(profissional);
            c.setValorConsulta(profissional.getValorHora().multiply(new BigDecimal(dto.getQuantidadeHoras())));
            c.setUpdatedAt(LocalDateTime.now());

            return consultaRepository.save(c);
        });
    }
}
