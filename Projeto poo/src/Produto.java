package Mercado;

public abstract class Produto {
    protected String tipo;
    protected double preco;
    protected int quantidade;
    protected String nome;

    public Produto(int quantidade, String nome, double preco, String tipo) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public abstract void Addproduto();

    // método para mostrar informação do produto (implementado nas subclasses)
    public void mostrar() {
        System.out.printf("%s - %s - Qtd: %d - R$ %.2f%n", tipo, nome, quantidade, preco);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() {
        return nome;
    }
}
