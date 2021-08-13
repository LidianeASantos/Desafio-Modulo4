package br.com.zup.lidiane.sistemadecompras.compra;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCompra(@RequestBody @Valid Compra compra) {
        compraService.adicionarCompraNaLista( compra );
    }

    @GetMapping
    public List<Compra> visualizarCompra(){
        return compraService.retornarListaDeCompra();
    }

    @GetMapping("/{cpf}")
    public List<Compra> mostrarCompraPorCliente(@PathVariable String cpf){
        return compraService.retornarListaDeCompraPorCliente( cpf );
    }

}
