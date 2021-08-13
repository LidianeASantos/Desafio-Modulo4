package br.com.zup.lidiane.sistemadecompras.compra;

import br.com.zup.lidiane.sistemadecompras.cliente.Cliente;
import br.com.zup.lidiane.sistemadecompras.produto.Produto;

import java.util.List;

    public class Compra {

    private Cliente cliente;

    private List<Produto> produtos;

    public Compra() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
