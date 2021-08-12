package br.com.zup.lidiane.sistemadecompras.produto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProdutoNaLista(Produto produto){
        produtos.add( produto );
    }

    public List<Produto> retornarProdutoNaLista(){
        return this.produtos;
    }
}
