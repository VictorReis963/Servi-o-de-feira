package br.com.frutasemcasa.produtos;

public class Produto {
    private int id; // idProduto
    private String nome;
    private String tipo; // Ex: "Bandeja de Fruta"

    public Produto(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    
    @Override
    public String toString() {
        return nome + " (" + tipo.replace("Bandeja de ", "") + ")";
    }
}