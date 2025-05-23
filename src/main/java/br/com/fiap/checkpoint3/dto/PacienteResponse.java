package br.com.fiap.checkpoint3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.checkpoint3.model.Paciente;

public class PacienteResponse {
    private Long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;
    private LocalDate dataNascimento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PacienteResponse toDto (Paciente paciente) {
        id = paciente.getId();
        nome = paciente.getNome();
        endereco = paciente.getEndereco();
        bairro = paciente.getBairro();
        email = paciente.getEmail();
        telefone_completo = paciente.getTelefone_completo();
        dataNascimento = paciente.getDataNascimento();
        createdAt = paciente.getCreatedAt();
        updatedAt = paciente.getUpdatedAt();
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
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone_completo() {
        return telefone_completo;
    }
    public void setTelefone_completo(String telefone_completo) {
        this.telefone_completo = telefone_completo;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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