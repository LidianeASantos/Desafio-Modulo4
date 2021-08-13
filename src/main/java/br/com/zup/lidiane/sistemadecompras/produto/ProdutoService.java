package br.com.zup.lidiane.sistemadecompras.produto;

import br.com.zup.lidiane.sistemadecompras.configuracao.ProdutoJaCadastradoException;
import br.com.zup.lidiane.sistemadecompras.configuracao.ProdutoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProdutoNaLista(Produto produto){
        verificarProdutoDuplicado( produto.getNome() );
        produtos.add( produto );
    }

    public List<Produto> retornarProdutoNaLista(){
        return this.produtos;
    }

    public Produto buscarProduto(String nome){
        Produto produto = null;
        for (Produto retorno : produtos){
            if (retorno.getNome().equals( nome )){
                return retorno;
            }
        } throw new ProdutoNaoEncontradoException("Produto não encontrado!");
    }

    public void verificarProdutoDuplicado(String nome){
        for (Produto retorno : produtos){
            if (retorno.getNome().equals( nome )){
                throw new ProdutoJaCadastradoException("Produto já cadastrado!");
            }
        }
    }




}
