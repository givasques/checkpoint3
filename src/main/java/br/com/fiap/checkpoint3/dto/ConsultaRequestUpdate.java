package br.com.fiap.checkpoint3.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ConsultaRequestUpdate {
    private Long profissionalId;
    private Long pacienteId;
    private LocalDateTime data;
    private BigInteger quantidadeHoras;

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
