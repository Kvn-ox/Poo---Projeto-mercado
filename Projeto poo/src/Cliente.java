package Cliente;

import Mercado.Produto;

import java.util.ArrayList;

public class Cliente {
    private String nome_cliente;
    private String cpf;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Cliente(String nome_cliente, String cpf) {
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
    }

    // adiciona produto no arraylist do cliente (carrinho)
    public void Addcarrinhodecompra(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    // calcula o total da compra baseada nos preços dos produtos no carrinho
    public double calculoTotalCompra() {
        double total = 0.0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }

    // exibe os itens que o cliente comprou
    public void mostrarCarrinho() {
        System.out.println("\n--- Itens no carrinho de " + nome_cliente + " ---");
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        for (Produto p : produtos) {
            p.mostrar();
        }
        System.out.printf("TOTAL = R$ %.2f%n", calculoTotalCompra());
    }

    public String getNome() {
        return nome_cliente;
    }

    public String getCpf() {
        return cpf;
    }
}
