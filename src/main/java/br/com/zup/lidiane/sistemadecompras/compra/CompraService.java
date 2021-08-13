package br.com.zup.lidiane.sistemadecompras.compra;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    private List<Compra> compras = new ArrayList<>();

    public void adicionarCompraNaLista(Compra compra){
        compras.add( compra );
    }


    public List<Compra> retornarListaDeCompra(){
        return this.compras;
    }

    public List<Compra> retornarListaDeCompraPorCliente(String cpf){
       retornarListaDeCompra();
       retornarListaDeCompraPorCliente(cpf);
       return compras;
    }




}
