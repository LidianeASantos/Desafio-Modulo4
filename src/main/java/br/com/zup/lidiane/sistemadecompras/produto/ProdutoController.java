package br.com.zup.lidiane.sistemadecompras.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarProduto(@RequestBody @Valid Produto produto){
        produtoService.adicionarProdutoNaLista( produto );
    }
}
