package br.com.zup.lidiane.sistemadecompras.configuracao;


import java.util.List;

public class ProdutosForaDeEstoqueException extends RuntimeException {

    public List<String> nomeDosProdutos;

    public ProdutosForaDeEstoqueException(List<String> nomeDosProdutos) {
        this.nomeDosProdutos = nomeDosProdutos;
    }


}
