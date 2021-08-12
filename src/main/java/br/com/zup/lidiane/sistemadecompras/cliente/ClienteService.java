package br.com.zup.lidiane.sistemadecompras.cliente;

import br.com.zup.lidiane.sistemadecompras.produto.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarClienteNaLista(Cliente cliente){
        clientes.add( cliente );
    }

    public Cliente pesquisarClientePorCPF(String cpf){
        Cliente cliente = null;
        for (Cliente retorno : clientes){
            if (retorno.getCpf().equals( cpf )) {
                return retorno;
            }

        }   throw new RuntimeException("Cliente não encontrado!");
    }
}
