package br.com.zup.lidiane.sistemadecompras.compra;

import br.com.zup.lidiane.sistemadecompras.cliente.Cliente;
import br.com.zup.lidiane.sistemadecompras.cliente.ClienteService;
import br.com.zup.lidiane.sistemadecompras.configuracao.ProdutosForaDeEstoqueException;
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

    @Autowired
    private ClienteService clienteService;

    private List<Compra> compras = new ArrayList<>();

  /*  public void adicionaCompraNaLista(Compra compra) {
        List<Produto> produtos = new ArrayList<>();

        for (Produto produto : compra.getProdutos()) {
            Produto produtoRetornado = produtoService.buscarProduto( produto.getNome() );
            produtos.add( produtoRetornado );

        }
        Cliente cliente = clienteService.pesquisarClientePorCPF( compra.getCliente().getCpf() );
        compra.setCliente( cliente );
        compra.setProdutos( produtos );

    }*/

    public List<Compra> retornarListaDeCompraPorCliente(String cpf) {
        List<Produto> produtos = new ArrayList<>();

         for (Compra percorrer : compras) {
            if (percorrer.getCliente().getCpf().equals( cpf )) {
                for (Produto elementoLista : percorrer.getProdutos()) {
                    produtos.add( elementoLista );
                }
            }
        }

        return compras;
    }

    public void registrarCompra(Compra compra){
        List<String> nomeDosProdutosForaDeEstoque = new ArrayList<>();

        for (Produto produto : compra.getProdutos()){
            if(produtoService.produtoEsgotado(produto)){
                nomeDosProdutosForaDeEstoque.add(produto.getNome());
            }else{
                compra.getProdutos().remove(produto);
                compra.getProdutos().add(produtoService.buscarProduto(produto));
            }
        }

        if(!nomeDosProdutosForaDeEstoque.isEmpty()){
            throw new ProdutosForaDeEstoqueException(nomeDosProdutosForaDeEstoque);
        }

        compras.add(compra);
    }


}
