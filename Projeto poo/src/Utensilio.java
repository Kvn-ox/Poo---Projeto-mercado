package Mercado.Utensilios;

import Mercado.Produto;

public class Utensilio extends Produto {
    private String marca;

    public Utensilio(int quantidade, String nome, double preco, String marca, String tipo) {
        super(quantidade, nome, preco, tipo);
        this.marca = marca;
    }

    @Override
    public void mostrar() {
        System.out.printf("[Utensílio] %s - Marca: %s - Preço: R$ %.2f - Qtd: %d%n",
                nome, marca, preco, quantidade);
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public void Addproduto() {
        System.out.println("Adicionando Utensilio");
    }
}
