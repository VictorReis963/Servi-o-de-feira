package br.com.frutasemcasa.cesta;

import java.util.ArrayList;
import java.util.List;

public class Cesta {
    private List<ItemCesta> itens; // Contém 1..* ItemCesta
    private String semanaReferencia; // -semanaReferencia : float (usado para referência semanal)
    private String status;

    public Cesta(String semanaReferencia) {
        this.semanaReferencia = semanaReferencia;
        this.itens = new ArrayList<>();
        this.status = "Pendente";
    }

    // Passo 9, 12, 15: Sistema armazena os itens escolhidos
    public void adicionarItem(ItemCesta item) {
        this.itens.add(item);
    }
    
    // Método para validar se a cesta está dentro do limite do plano (usa a classe Plano)
    public int contarItensPorTipo(String tipo) {
        return (int) itens.stream()
            .filter(item -> item.getProduto().getTipo().contains(tipo.replace("Bandeja de ", "")))
            .count();
    }

    // Getters e Setters
    public List<ItemCesta> getItens() { return itens; }
    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
}