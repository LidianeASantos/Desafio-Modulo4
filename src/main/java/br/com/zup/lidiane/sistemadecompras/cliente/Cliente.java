package br.com.zup.lidiane.sistemadecompras.cliente;

import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Cliente {

    @NotBlank(message = "{validacao.nome}")
    private String nome;

    @CPF(message = "{validacao.cpf}")
    private String cpf;

    @Email(message = "{validacao.email}")
    private String email;


    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
