package Mercado.Alimentos;

import Mercado.Produto;
import Mercado.ValidadeException;

public class Comida extends Produto implements Descartavel {

    private double peso;
    private String validade;

    public Comida(double preco, int quantidade, double peso, String nome, String validade, String tipo) {
        super(quantidade, nome, preco, tipo);
        this.peso = peso;
        this.validade = validade;
    }

    public String getValidade() { return validade; }

    public boolean validadeOk(String hoje) throws ValidadeException {
        if (hoje.compareTo(validade) > 0) {
            throw new ValidadeException("Produto vencido: " + getNome());
        }
        return true;
    }

    @Override
    public boolean Descartar() {
        return false;
    }

    @Override
    public void mostrar() {
        System.out.println(getNome() + " | R$ " + getPreco() + " | Val: " + validade);
    }
}
