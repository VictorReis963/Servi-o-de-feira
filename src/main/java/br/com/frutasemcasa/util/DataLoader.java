package br.com.frutasemcasa.util;

import br.com.frutasemcasa.entidades.Plano;
import br.com.frutasemcasa.produtos.Produto;

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {

    // Caminho base para acessar os arquivos na pasta 'src/main/resources/'
    private static final String RESOURCE_BASE_PATH = "src/main/resources/";
    
    // Método utilitário para obter um BufferedReader usando o caminho relativo.
    private static BufferedReader getReaderFromResource(String fileName) {
        String fullPath = RESOURCE_BASE_PATH + fileName;
        try {
            return new BufferedReader(new FileReader(fullPath));
        } catch (IOException e) {
            System.err.println("ERRO FATAL: Arquivo não encontrado no caminho direto: " + fullPath);
            e.printStackTrace();
            return null;
        }
    }

    public static List<Plano> carregarPlanos(String fileName) {
        List<Plano> planos = new ArrayList<>();
        String DELIMITADOR = ","; 
        
        try (BufferedReader br = getReaderFromResource(fileName)) {
            if (br == null) return planos;
            
            br.readLine(); // Ignora cabeçalho

            planos = br.lines()
                       // === AJUSTE DE ROBUSTEZ: IGNORA LINHAS VAZIAS OU APENAS ESPAÇOS ===
                       .filter(linha -> !linha.trim().isEmpty()) 
                       // =================================================================
                       .map(linha -> {
                           String[] dados = linha.trim().split(DELIMITADOR);

                           try {
                               int idPlano = Integer.parseInt(dados[0].trim());
                               String nome = dados[1].trim();
                               float valorBase = Float.parseFloat(dados[2].trim());
                               int qtdFrutas = Integer.parseInt(dados[3].trim());
                               int qtdLegumes = Integer.parseInt(dados[4].trim());
                               int qtdVerduras = Integer.parseInt(dados[5].trim());
                               
                               return new Plano(idPlano, nome, valorBase, qtdFrutas, qtdLegumes, qtdVerduras);
                           } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                               // Esta mensagem de erro não será mais ativada por linhas vazias
                               System.err.println("Erro ao processar linha do Plano: " + linha);
                               return null;
                           }
                       })
                       .filter(p -> p != null)
                       .collect(Collectors.toList());

        } catch (IOException e) {
            // Este catch pega erros de I/O não capturados pelo getReaderFromResource
        }
        return planos;
    }

    public static List<Produto> carregarProdutos(String fileName) {
        List<Produto> produtos = new ArrayList<>();
        String DELIMITADOR = ",";

        try (BufferedReader br = getReaderFromResource(fileName)) {
             if (br == null) return produtos;

             br.readLine(); // Ignora cabeçalho

             produtos = br.lines()
                          // === AJUSTE DE ROBUSTEZ: IGNORA LINHAS VAZIAS OU APENAS ESPAÇOS ===
                          .filter(linha -> !linha.trim().isEmpty())
                          // =================================================================
                          .map(linha -> {
                              String[] dados = linha.trim().split(DELIMITADOR);

                              try {
                                  int idProduto = Integer.parseInt(dados[0].trim());
                                  String nome = dados[1].trim();
                                  String tipo = dados[2].trim();

                                  // Correção de codificação
                                  nome = corrigirCodificacao(nome); 

                                  return new Produto(idProduto, nome, tipo);
                              } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                  System.err.println("Erro ao processar linha do Produto: " + linha);
                                  return null;
                              }
                          })
                          .filter(p -> p != null)
                          .collect(Collectors.toList());

        } catch (IOException e) {
             // Este catch pega erros de I/O não capturados pelo getReaderFromResource
        }
        return produtos;
    }
    
    // Método utilitário para corrigir a codificação (sem alterações)
    private static String corrigirCodificacao(String texto) {
        return texto
            .replace("Ã§", "ç")
            .replace("Ã£", "ã")
            .replace("Ã¡", "á")
            .replace("Ã³", "ó")
            .replace("Ãº", "ú")
            .replace("Ã³", "ó")
            .replace("Ãª", "ê")
            .replace("Ã", "a");
    }
}