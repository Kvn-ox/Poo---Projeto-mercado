import Cliente.Cliente;
import Mercado.Produto;
import Mercado.ValidadeException;
import Mercado.Alimentos.Comida;
import Mercado.Utensilios.Utensilio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente c1 = new Cliente("Kevin", "13276703726");
        String hoje = "20/02/2026";

        // LISTA DE PRODUTOS
        ArrayList<Object> produtos = new ArrayList<>();

        produtos.add(new Utensilio(3, "Machado", 10, "Hammer", "Ferramenta"));
        produtos.add(new Utensilio(4, "Isqueiro", 2, "Bic", "Ferramenta"));

        produtos.add(new Comida(6, 6, 1, "Leite", "25/12/2025", "Alimento"));
        produtos.add(new Comida(5, 12, 1, "Danone", "25/12/2025", "Alimento"));

        // adicionados como você pediu
        produtos.add(new Comida(3, 15, 1, "Banana", "21/02/2026", "Alimento"));
        produtos.add(new Comida(4, 20, 1, "Maçã", "20/02/2026", "Alimento"));


        int op = -1;

        while (op != 0) {
            System.out.println("\n=== MERCADIN ===");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Comprar");
            System.out.println("3 - Finalizar compra");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            op = sc.nextInt();

            if (op == 1) {
                for (int i = 0; i < produtos.size(); i++) {
                    System.out.print(i + " - ");
                    ((Produto) produtos.get(i)).mostrar();
                }
            }

            else if (op == 2) {
                System.out.print("Digite o número do produto: ");
                int idx = sc.nextInt();

                if (idx < 0 || idx >= produtos.size()) {
                    System.out.println("Produto inválido.");
                    continue;
                }

                Object obj = produtos.get(idx);

                if (obj instanceof Comida) {
                    try {
                        Comida comida = (Comida) obj;
                        comida.validadeOk(hoje);
                        c1.adicionarProduto(comida);
                        System.out.println("Adicionado ao carrinho!");
                    } catch (ValidadeException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    Produto p = (Produto) obj;
                    c1.adicionarProduto(p);
                    System.out.println("Adicionado ao carrinho!");
                }
            }

            else if (op == 3) {
                c1.mostrarCompras();
            }
        }
    }
}
