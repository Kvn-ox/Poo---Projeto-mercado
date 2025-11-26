package Mercado.Alimentos;

import Mercado.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Comida extends Produto implements Descartavel {

    private double peso;
    private String validade; // formato "dd/MM/yyyy"

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Comida(double preco, int quantidade, double peso, String nome, String validade, String tipo) {
        super(quantidade, nome, preco, tipo);
        this.peso = peso;
        this.validade = validade;
    }

    public double getPeso() {
        return peso;
    }

    public String getValidade() {
        return validade;
    }

    // mostra dados do produto (sobrescreve/usa o padrão)
    @Override
    public void mostrar() {
        System.out.printf("[Comida] %s - Preço: R$ %.2f - Qtd: %d - Validade: %s%n",
                nome, preco, quantidade, validade);
    }

    // verifica se a validade é maior ou igual a data informada (hoje)
    public boolean validadeOk(String hoje) {
        try {
            LocalDate dataHoje = LocalDate.parse(hoje, FORMAT);
            LocalDate dataVal = LocalDate.parse(this.validade, FORMAT);
            // retorna true se dataVal for igual ou depois de dataHoje
            return !dataVal.isBefore(dataHoje);
        } catch (DateTimeParseException ex) {
            // se não conseguir parsear, assume inválido (mais seguro)
            System.out.println("Erro ao interpretar datas (valdadeOk). Formato esperado dd/MM/yyyy.");
            return false;
        }
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void Addproduto() {
        System.out.println("Adicionando comida");
    }

    // implementação simples: aqui retorna true se a validade for "sim" (mas normalmente não usaremos)
    @Override
    public boolean Descartar() {
        return "sim".equalsIgnoreCase(validade);
    }
}
