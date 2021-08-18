package br.com.zup.lidiane.sistemadecompras.configuracao;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String message) {
        super(message);
    }
}
