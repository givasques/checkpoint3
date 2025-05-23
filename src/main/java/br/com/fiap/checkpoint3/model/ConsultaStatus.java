package br.com.fiap.checkpoint3.model;

public enum ConsultaStatus {
    AGENDADA ("Consulta Agendada!"),
    REALIZADA ("Consulta Realizada!"),
    CANCELADA ("Consulta Cancelada!");

    ConsultaStatus(String mensagem) {
       this.mensagem = mensagem;
    }

    String mensagem;

    public String getMensagem () {
        return mensagem;
    }
}
