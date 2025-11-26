import Cliente.Cliente;
import Mercado.Alimentos.Comida;
import Mercado.Utensilios.Utensilio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // CLIENTE
        Cliente c1 = new Cliente("Kevin", "132.767.037.26");
        String hoje = "20/02/2026";

        // LISTA DE PRODUTOS DISPONÍVEIS (tipo Produto é superclasse; aqui mantemos Object apenas para compatibilidade)
        ArrayList<Object> produtos = new ArrayList<>();
        produtos.add(new Utensilio(3, "machado", 10, "hammer", "ferramenta"));
        produtos.add(new Utensilio(4, "isqueiro", 2, "bic", "ferramenta"));
        produtos.add(new Comida(25, 6, 1, "leite", "25/12/2025", "alimento"));
        produtos.add(new Comida(30, 6, 1, "Danone", "25/12/2025", "alimento"));
        // (se quiser usar banana/maça, adicione com as datas do seu arquivo)

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n==== MERCADO ====");
            System.out.println("Cliente: " + c1.getNome());
            System.out.println("Data de hoje: " + hoje);

            System.out.println("\n1 - Mostrar produtos");
            System.out.println("2 - Comprar produto");
            System.out.println("3 - Finalizar compra (mostrar carrinho)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            // proteger caso o usuário digite algo diferente de int
            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("\n--- PRODUTOS DISPONÍVEIS ---");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.print(i + " - ");
                        Object p = produtos.get(i);
                        if (p instanceof Comida) {
                            ((Comida) p).mostrar();
                        } else if (p instanceof Utensilio) {
                            ((Utensilio) p).mostrar();
                        } else {
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nDigite o ID do produto que deseja comprar:");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.print(i + " - ");
                        Object p = produtos.get(i);
                        if (p instanceof Comida) {
                            ((Comida) p).mostrar();
                        } else if (p instanceof Utensilio) {
                            ((Utensilio) p).mostrar();
                        } else {
                            System.out.println(p.toString());
                        }
                    }

                    System.out.print("Produto (ID): ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Digite um ID válido: ");
                        sc.next();
                    }
                    int id = sc.nextInt();

                    if (id < 0 || id >= produtos.size()) {
                        System.out.println("ID inválido.");
                        break;
                    }

                    Object escolhido = produtos.get(id);

                    // Verificação de validade ANTES de comprar — se for Comida
                    if (escolhido instanceof Comida) {
                        Comida comida = (Comida) escolhido;
                        if (!comida.validadeOk(hoje)) {
                            System.out.println("❌ Esse alimento está VENCIDO! Não pode comprar.");
                        } else {
                            // adiciona no arraylist do cliente
                            c1.Addcarrinhodecompra(comida);
                        }
                    } else if (escolhido instanceof Utensilio) {
                        // Utensílio: adiciona direto
                        c1.Addcarrinhodecompra((Utensilio) escolhido);
                    } else {
                        System.out.println("Tipo de produto desconhecido.");
                    }
                    break;

                case 3:
                    // mostra o carrinho do cliente (itens adicionados no Cliente)
                    c1.mostrarCarrinho();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 0);

        sc.close();
    }
}
