package br.com.frutasemcasa.cesta;

import br.com.frutasemcasa.produtos.Produto;

public class ItemCesta {
    private Produto produto; // Referência 1..1 para Produto (refere-se)
    private int quantidade; // -quantidade : int

    public ItemCesta(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}