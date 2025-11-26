package Mercado.Alimentos;
import Mercado.Produto;
public class Comida extends Produto implements Descartavel{

    private double peso;
    private String validade;

    public Comida(double preco, int quantidade, double peso, String nome, String validade,  String tipo) {
        super(quantidade, nome, preco, tipo);
        this.peso = peso;
        this.validade = validade;

    }
    public double getPeso()
    {
        return peso;
    }

    public String getValidade()
    {
        return validade;
    }

    @Override
    public void Addproduto(){
        System.out.println("Adicionando comida");
    }

    @Override
    public boolean Descartar() {
        if (validade=="sim")
        {
            return true;

        }
        else {
            return false;
        }
    }
}