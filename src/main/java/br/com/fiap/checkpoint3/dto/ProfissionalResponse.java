package br.com.fiap.checkpoint3.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.fiap.checkpoint3.model.Profissional;

public class ProfissionalResponse {
    private Long id;
    private String nome;
    private String especialidade;
    private BigDecimal valorHora;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProfissionalResponse toDto (Profissional profissional) {
        id = profissional.getId();
        nome = profissional.getNome();
        especialidade = profissional.getEspecialidade();
        valorHora = profissional.getValorHora();
        createdAt = profissional.getCreatedAt();
        updatedAt = profissional.getUpdatedAt();
        return this;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public BigDecimal getValorHora() {
        return valorHora;
    }
    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}