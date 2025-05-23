package br.com.fiap.checkpoint3.dto;

import java.time.LocalDate;

import br.com.fiap.checkpoint3.model.Paciente;

public class PacienteRequestCreate {
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;
    private LocalDate dataNascimento;

    public Paciente toModel () {
        Paciente paciente = new Paciente ();
        paciente.setNome(nome);
        paciente.setEndereco(endereco);
        paciente.setBairro(bairro);
        paciente.setEmail(email);
        paciente.setTelefone_completo(telefone_completo);
        paciente.setDataNascimento(dataNascimento);
        return paciente;
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
}