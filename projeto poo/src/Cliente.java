package Cliente;

import Mercado.Produto;

import java.util.ArrayList;

    public class Cliente {
    private String nome_cliente;
    private String cpf;

    public Cliente(String nome_cliente, String cpf) {
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
    }

    private ArrayList<Produto> produtos = new ArrayList<>();

    public void calculoTotalCompra() {

    }
    public void Addcarrinhodecompra(Produto produto) {

    }
}