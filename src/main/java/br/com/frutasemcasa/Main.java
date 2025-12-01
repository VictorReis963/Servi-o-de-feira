package br.com.frutasemcasa;

import br.com.frutasemcasa.entidades.Assinante;
import br.com.frutasemcasa.entidades.Assinatura;
import br.com.frutasemcasa.entidades.Endereco;
import br.com.frutasemcasa.entidades.Plano;
import br.com.frutasemcasa.produtos.Produto;
import br.com.frutasemcasa.cesta.Cesta;
import br.com.frutasemcasa.cesta.ItemCesta;
import br.com.frutasemcasa.util.DataLoader;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Simulação: Cenário de Uso - Assinar Serviço de Feira");
        System.out.println("=================================================");
        
        // --- PREPARAÇÃO: Carregar Dados ---
        

        String PLANO_CSV_PATH = "Plano.csv";
        String PRODUTO_CSV_PATH = "Produto.csv"; 

        List<Plano> planosDisponiveis = DataLoader.carregarPlanos(PLANO_CSV_PATH);
        List<Produto> catalogo = DataLoader.carregarProdutos(PRODUTO_CSV_PATH);
        
        if (planosDisponiveis.isEmpty() || catalogo.isEmpty()) {
            System.out.println("ERRO: Dados não carregados. Verifique o caminho dos arquivos CSV.");
            return;
        }
        
        // --- INÍCIO DO FLUXO (Cenário Principal) ---

        // 1. O Assinante informa seu número de celular
        Assinante assinante = new Assinante("Maria Assinante", "11998877665", "maria@email.com");
        System.out.println("1. Assinante iniciado: " + assinante.getDados());

        // 2, 3, 4. Simula validação por SMS
        if (assinante.validarCodigoSMS("1234")) {
            System.out.println("2-4. Validação por SMS bem-sucedida.");
        }
        
        // 5. Sistema busca relação de planos
        Plano planoSelecionado = planosDisponiveis.get(1); // Ex: "basico plus" (ID 2)
        System.out.println("5-6. Plano selecionado: " + planoSelecionado.getNome() + " (R$ " + planoSelecionado.getValorBase() + ")");

        // Cria a Assinatura (vínculo inicial)
        Assinatura assinatura = new Assinatura(1, assinante, planoSelecionado);
        
        // 7-15. Montagem da Cesta (Seleção de Produtos)
        Cesta cestaSemanal = new Cesta("2025-40");
        
        // Simulação da Escolha: O sistema garante que a quantidade máxima por tipo não seja excedida.
        
        // Escolhe Frutas (limite 4 no 'basico plus')
        int maxFrutas = planoSelecionado.getQtdMaximaPorTipo("Fruta");
        cestaSemanal.adicionarItem(new ItemCesta(catalogo.get(0), 1)); // 1. Banana
        cestaSemanal.adicionarItem(new ItemCesta(catalogo.get(1), 1)); // 2. Maçã
        cestaSemanal.adicionarItem(new ItemCesta(catalogo.get(2), 1)); // 3. Laranja
        cestaSemanal.adicionarItem(new ItemCesta(catalogo.get(3), 1)); // 4. Mamão
        
        // Escolhe Legumes (limite 4 no 'basico plus')
        cestaSemanal.adicionarItem(new ItemCesta(catalogo.get(15), 1)); // 1. Cenoura
        cestaSemanal.adicionarItem(new ItemCesta(catalogo.get(16), 1)); // 2. Beterraba
        
        assinatura.setCesta(cestaSemanal); // Armazena a cesta na Assinatura
        System.out.println("7-15. Cesta montada com sucesso. Total de itens: " + cestaSemanal.getItens().size());
        
        // 16-17. Solicita e informa Endereço de Entrega
        Endereco enderecoEntrega = new Endereco("Rua das Flores", 100, "São Paulo", "01000100", "SP");
        assinatura.setEndereco(enderecoEntrega);
        System.out.println("16-18. Endereço de Entrega Armazenado: " + enderecoEntrega);

        // 19. Sistema muda o status da compra para aguardando aprovação (feito em processaPagamento)
        // 20. Sistema apresenta o total e solicita pagamento
        System.out.println("20. Total da Assinatura: R$ " + planoSelecionado.getValorBase());

        // 21. Assinante informa dados do cartão de crédito para pagamento
        String dadosCartaoValidos = "1234567890123456"; 
        
        // 22. Sistema valida pagamento, armazena dados, muda status
        if (assinatura.processaPagamento(dadosCartaoValidos)) {
            // 23. Sistema exibe mensagens de operação realizada com sucesso
            System.out.println("\n--- Operação Realizada com Sucesso ---");
            System.out.println("22. Pagamento Aprovado. Status Assinatura: " + assinatura.getStatus());
            System.out.println("24. Protocolo da Assinatura: " + assinatura.getProtocolo());
            System.out.println("Cesta (" + assinatura.getCesta().getStatus() + ") será enviada para: " + enderecoEntrega);
        } else {
            System.out.println("Pagamento Recusado. Status: " + assinatura.getStatus());
        }

        // 25. O caso de uso é encerrado.
        System.out.println("=================================================");
    }
}