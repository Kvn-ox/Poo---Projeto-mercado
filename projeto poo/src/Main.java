
import Cliente.Cliente;
import Mercado.Alimentos.Comida;
import Mercado.Utensilios.Utensilio;
public class Main {
    public static void main(String[] args) {




        //treads iremos fazer aqui na main


        Cliente c1 = new Cliente("Kevin","132.767.037.26");
        String hoje = "20/02/2026";

        // gerar um menu para mostrar os itens
        // comprar do cliente, escolhendo o produto (verificar a validade) (adicionar na arraylist)
        // finalizar e mostrar oq ele comprou




        Utensilio f1 = new Utensilio(3, "machado", 10, "hammer",  "ferramenta");
        Utensilio f2 = new Utensilio(4, "isqueiro", 2, "bic",  "ferramenta");
        Comida a1 = new Comida(25 ,6, 1, "leite", "25/12/2025","alimento");
        Comida a2 = new Comida(30 ,6, 1, "Danone", "25/12/2025","alimento");
    }
}