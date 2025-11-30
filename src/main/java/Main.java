import dao.*;
import model.*;
import service.AssinaturaService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        PlanoDAO planoDAO = new PlanoDAO();

        List<Produto> produtos = produtoDAO.loadAll();
        List<Plano> planos = planoDAO.loadAll();

        System.out.println("=== Cadastro de Assinatura ===");

        System.out.print("Seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Seu celular: ");
        String cel = sc.nextLine();

        System.out.print("Seu email: ");
        String email = sc.nextLine();

        Assinante assinante = new Assinante(nome, cel, email);

        System.out.println("\nPlanos disponiveis:");
        for (Plano p : planos) {
            System.out.println(p.getId() + " - " + p.getNome()
            + " | Frutas:" + p.getQtdFrutas() + " Legumes:" + p.getQtdLegumes());
        }

        System.out.print("Escolha o ID do plano: ");
        int idPlano = sc.nextInt();
        sc.nextLine();

        Plano planoEscolhido = planos.stream()
                .filter(p -> p.getId() == idPlano)
                .findFirst().orElse(null);

        if (planoEscolhido == null) {
            System.out.println("Plano invalido.");
            return;
        }

        System.out.println("\nMonte sua Cesta");
        Cesta cesta = new Cesta(1, 1, "PENDENTE");

        List<ItemCesta> itens = new ArrayList<>();

        while (true) {
            System.out.println("\nProdutos:");
            for (Produto p : produtos) {
                System.out.println(p.getId() + " - " + p.getNome() + " (" + p.getTipo() + ")");
            }

            System.out.print("Escolha o idProduto (0 para finalizar): ");
            int idProd = sc.nextInt();
            sc.nextLine();

            if (idProd == 0) break;

            System.out.print("Quantidade: ");
            int qtd = sc.nextInt();
            sc.nextLine();

            itens.add(new ItemCesta(1, idProd, qtd));
        }

        AssinaturaService service = new AssinaturaService();

        boolean ok = service.validarCesta(cesta, planoEscolhido, itens, produtos);

        if (!ok) {
            System.out.println("\nCesta incompatível com o plano!");
            return;
        }

        System.out.println("\nCesta valida! Finalizando assinatura…");

        Assinatura assinatura = service.criarAssinatura(assinante, planoEscolhido, cesta, itens);

        System.out.println("\nAssinatura criada com sucesso!");
        System.out.println("Protocolo: " + assinatura.getProtocolo());
    }
}
