package br.com.zup.lidiane.sistemadecompras.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

}
