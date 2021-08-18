package br.com.zup.lidiane.sistemadecompras.cliente;

import br.com.zup.lidiane.sistemadecompras.configuracao.ClienteComEmailJaCadastrdoException;
import br.com.zup.lidiane.sistemadecompras.configuracao.ClienteComCPFJaCadastradoException;
import br.com.zup.lidiane.sistemadecompras.configuracao.ClienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarClienteNaLista(Cliente cliente){
        verificarEmailDuplicado( cliente.getEmail() );
        verificarCPFDuplicado( cliente.getCpf() );
        clientes.add( cliente );
    }

    public Cliente pesquisarClientePorCPF(String cpf){
        Cliente cliente = null;
        for (Cliente retorno : clientes){
            if (retorno.getCpf().equals( cpf )) {
                return retorno;
            }

        }   throw new ClienteNaoEncontradoException("Cliente não encontrado!");
    }

    public void verificarEmailDuplicado(String email){
        for (Cliente retorno : clientes){
            if (retorno.getEmail().equals( email )){
                throw new ClienteComEmailJaCadastrdoException("Cliente com email já cadastrado!");
            }
        }
    }

    public void verificarCPFDuplicado(String cpf){
        for (Cliente retorno : clientes){
            if (retorno.getCpf().equals( cpf )){
                throw new ClienteComCPFJaCadastradoException("Cliente com CPF já cadastrado!");
            }
        }
    }



}
