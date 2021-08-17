package br.com.zup.lidiane.sistemadecompras.compra;

import br.com.zup.lidiane.sistemadecompras.cliente.Cliente;
import br.com.zup.lidiane.sistemadecompras.cliente.ClienteService;
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

    public void adicionaCompraNaLista(Compra compra) {
        List<Produto> produtos = new ArrayList<>();

        for (Produto produto : compra.getProdutos()) {
            Produto produtoRetornado = produtoService.buscarProduto( produto.getNome() );
            produtos.add( produtoRetornado );

        }
        Cliente cliente = clienteService.pesquisarClientePorCPF( compra.getCliente().getCpf() );
        compra.setCliente( cliente );
        compra.setProdutos( produtos );

    }

    public List<Compra> retornarListaDeCompraPorCliente(String cpf) {
        List<Produto> produtos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        for (Compra percorrer : compras) {

            percorrer.getCliente().getCpf().equals( cpf );
            percorrer.getProdutos().equals( produtos );

        }
        Cliente cliente = clienteService.pesquisarClientePorCPF( cpf );

        produtoService.retornarProdutoNaLista();
        clienteService.pesquisarClientePorCPF( cpf );


        return compras;
    }

}
