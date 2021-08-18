package br.com.zup.lidiane.sistemadecompras.compra;

import br.com.zup.lidiane.sistemadecompras.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compra cadastrarCompra(@RequestBody @Valid Compra compra) {
        compraService.adicionaCompraNaLista( compra );
        return compra;
    }


    @GetMapping("/{cpf}")
    public List<Compra> mostrarCompraPorCliente(@PathVariable String cpf){
        return compraService.retornarListaDeCompraPorCliente( cpf );
    }

}
