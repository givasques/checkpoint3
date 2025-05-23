package br.com.fiap.checkpoint3.dto;

import java.math.BigDecimal;

import br.com.fiap.checkpoint3.model.Profissional;

public class ProfissionalRequestUpdate {
    private String nome;
    private String especialidade;
    private BigDecimal valorHora;

    public Profissional toModel (Profissional profissional) {
        profissional.setNome(nome);
        profissional.setEspecialidade(especialidade);
        profissional.setValorHora(valorHora);
        return profissional;
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
}