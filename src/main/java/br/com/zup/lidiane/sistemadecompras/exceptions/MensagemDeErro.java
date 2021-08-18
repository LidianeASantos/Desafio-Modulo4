package br.com.zup.lidiane.sistemadecompras.exceptions;

import java.util.List;

public class MensagemDeErro {

    private int statusCode;
    private List<Erro> erros;
    private String mensagem;

    public MensagemDeErro(int statusCode, List<Erro> erros) {
        this.statusCode = statusCode;
        this.erros = erros;
    }

    public MensagemDeErro(String s) {
        mensagem = s;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }
}
