package br.com.zup.lidiane.sistemadecompras.cliente;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarClienteNaLista(Cliente cliente){
        clientes.add( cliente );
    }
}
