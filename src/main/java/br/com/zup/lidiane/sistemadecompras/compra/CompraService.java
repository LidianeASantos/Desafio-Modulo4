package br.com.zup.lidiane.sistemadecompras.compra;

import br.com.zup.lidiane.sistemadecompras.produto.Produto;
import br.com.zup.lidiane.sistemadecompras.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private ProdutoService produtoService;

    private List<Compra> compras = new ArrayList<>();

    public void adicionaCompraNaLista(Compra compra){
        compras.add( compra );

    }

    public Compra mostrarListaDeCompra(Compra compra){
        List<Produto> produtos = compra.getProdutos();
        List<Produto> objetoProdutos = new ArrayList<>();

        for (Produto percorrer : produtos){
            Produto objeto = produtoService.buscarProduto( percorrer.getNome());
            objetoProdutos.add( objeto );
        }
        compra.setProdutos( objetoProdutos );
        compras.add( compra );
        return compra;
    }

    public List<Compra> retornarListaDeCompra(){
        return this.compras;
    }

   public List<Compra> retornarListaDeCompraPorCliente(String cpf){
        retornarListaDeCompraPorCliente(cpf);
        return compras;
    }




}
