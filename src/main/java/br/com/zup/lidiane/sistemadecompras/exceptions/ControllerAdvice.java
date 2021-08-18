package br.com.zup.lidiane.sistemadecompras.exceptions;

import br.com.zup.lidiane.sistemadecompras.configuracao.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<Erro> erros = fieldErrors.stream().map( objeto -> new Erro( objeto.getDefaultMessage() ) )
                .collect( Collectors.toList());

        return new MensagemDeErro( 400, erros );
    }

    @ExceptionHandler(ProdutosForaDeEstoqueException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularProdutosForaDeEstoqueExcption(ProdutosForaDeEstoqueException exception){
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Os produtos a seguir estão em falta no momento: ");

        for (String nomeDoProduto : exception.nomeDosProdutos){
            mensagem.append(nomeDoProduto+" ");
        }

        return new MensagemDeErro(mensagem.toString());
    }

    @ExceptionHandler(ClienteComCPFJaCadastradoException.class)
    public MensagemDeErro manipularClienteComCPFJaCadastrado(ClienteComCPFJaCadastradoException exception){
        List<Erro> erros = Arrays.asList( new Erro( exception.getLocalizedMessage() ) );

        return new MensagemDeErro( 400, erros );
    }

    @ExceptionHandler(ClienteComEmailJaCadastrdoException.class)
    public MensagemDeErro manipularClienteComEmailJaCadastrado(ClienteComEmailJaCadastrdoException exception){
        List<Erro> erros = Arrays.asList( new Erro( exception.getLocalizedMessage() ) );
        return new MensagemDeErro( 400, erros );
    }

    @ExceptionHandler(ProdutoJaCadastradoException.class)
    public MensagemDeErro manipularProdutoJaCadastrdo(ProdutoJaCadastradoException exception){
        List<Erro> erros = Arrays.asList( new Erro( exception.getLocalizedMessage() ) );
        return new MensagemDeErro( 400, erros );
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public MensagemDeErro manipularProdutoNaoEncontrado(ProdutoNaoEncontradoException exception){
        List<Erro> erros = Arrays.asList( new Erro( exception.getLocalizedMessage() ) );
        return new MensagemDeErro( 400, erros );
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public MensagemDeErro manipularClienteNaoEncontrado(ClienteNaoEncontradoException exception){
        List<Erro> erros = Arrays.asList( new Erro( exception.getLocalizedMessage() ) );
        return new MensagemDeErro( 400, erros );
    }
}
