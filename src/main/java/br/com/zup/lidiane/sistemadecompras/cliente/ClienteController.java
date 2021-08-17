package br.com.zup.lidiane.sistemadecompras.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody @Valid Cliente cliente){ //TODO: verificar erro 500
        clienteService.adicionarClienteNaLista( cliente );
    }


    @GetMapping("/{cpf}")
    public Cliente pesquisarClientePorCPF(@PathVariable String cpf){
        return clienteService.pesquisarClientePorCPF( cpf );
    }
}
