package br.com.zup.lidiane.sistemadecompras.produto;

import javax.validation.constraints.*;

public class Produto {

    @NotBlank(message = "{validacao.nome.produto}")
    private String nome;

    @Min( value = 1, message = "{validacao.preco}")
    private double preco;

    @Min( value = 1, message = "{validacao.quantidade}")
    private int quantidade;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
