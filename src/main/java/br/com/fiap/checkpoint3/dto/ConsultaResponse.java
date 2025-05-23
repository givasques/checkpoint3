package br.com.fiap.checkpoint3.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import br.com.fiap.checkpoint3.model.Consulta;

public class ConsultaResponse {
    private Long id;
    private ProfissionalResponse profissional;
    private PacienteResponse paciente;
    private LocalDateTime data;
    private String status;
    private BigInteger quantidadeHoras;
    private BigDecimal valorConsulta;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ConsultaResponse toDto (Consulta consulta) {
        this.setId(consulta.getId());
        this.setProfissional(new ProfissionalResponse().toDto(consulta.getProfissional()));
        this.setPaciente(new PacienteResponse().toDto(consulta.getPaciente()));
        this.setData(consulta.getData());
        this.setStatus(consulta.getStatus().getMensagem());
        this.setQuantidadeHoras(consulta.getQuantidadeHoras());
        this.setValorConsulta(consulta.getValorConsulta());
        this.setCreatedAt(consulta.getCreatedAt());
        this.setUpdatedAt(consulta.getUpdatedAt());
        return this;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ProfissionalResponse getProfissional() {
        return profissional;
    }
    public void setProfissional(ProfissionalResponse profissional) {
        this.profissional = profissional;
    }
    public PacienteResponse getPaciente() {
        return paciente;
    }
    public void setPaciente(PacienteResponse paciente) {
        this.paciente = paciente;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public BigInteger getQuantidadeHoras() {
        return quantidadeHoras;
    }
    public void setQuantidadeHoras(BigInteger quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }
    public void setValorConsulta(BigDecimal valorConsulta) {
        this.valorConsulta = valorConsulta;
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
