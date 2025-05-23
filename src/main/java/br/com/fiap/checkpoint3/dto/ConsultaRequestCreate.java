package br.com.fiap.checkpoint3.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import br.com.fiap.checkpoint3.model.Consulta;
import br.com.fiap.checkpoint3.model.ConsultaStatus;
import br.com.fiap.checkpoint3.model.Paciente;
import br.com.fiap.checkpoint3.model.Profissional;

public class ConsultaRequestCreate {
    private Long profissionalId;
    private Long pacienteId;
    private LocalDateTime data;
    private BigInteger quantidadeHoras;

    public Consulta toModel (Paciente paciente, Profissional profissional) {
        Consulta consulta = new Consulta();
        consulta.setCreatedAt(LocalDateTime.now());
        consulta.setUpdatedAt(LocalDateTime.now());
        consulta.setData(this.getData());
        consulta.setQuantidadeHoras(this.getQuantidadeHoras());
        consulta.setStatus(ConsultaStatus.AGENDADA);
        consulta.setPaciente(paciente);
        consulta.setProfissional(profissional);
        consulta.setValorConsulta(profissional.getValorHora().multiply(new BigDecimal(quantidadeHoras)));
        return consulta;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }
    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }
    public Long getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public BigInteger getQuantidadeHoras() {
        return quantidadeHoras;
    }
    public void setQuantidadeHoras(BigInteger quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
}
