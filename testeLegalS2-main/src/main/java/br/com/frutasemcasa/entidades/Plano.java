package br.com.frutasemcasa.entidades;

public class Plano {
    private int id; // idPlano
    private String nome;
    private float valorBase; // valorBase
    private int qtdFrutasPermitidas; // qtdFrutasPermitidas
    private int qtdLegumesPermitidos; // qtdLegumesPermitidos
    private int qtdVerdurasPermitidas; // qtdVerdurasPermitidas

    public Plano(int id, String nome, float valorBase, int qtdFrutasPermitidas, int qtdLegumesPermitidos, int qtdVerdurasPermitidas) {
        this.id = id;
        this.nome = nome;
        this.valorBase = valorBase;
        this.qtdFrutasPermitidas = qtdFrutasPermitidas;
        this.qtdLegumesPermitidos = qtdLegumesPermitidos;
        this.qtdVerdurasPermitidas = qtdVerdurasPermitidas;
    }

    // Retorna a quantidade máxima de itens que o cliente pode escolher por tipo
    public int getQtdMaximaPorTipo(String tipoProduto) {
        if (tipoProduto.contains("Fruta")) {
            return qtdFrutasPermitidas;
        } else if (tipoProduto.contains("Legume")) {
            return qtdLegumesPermitidos;
        } else if (tipoProduto.contains("Verdura")) {
            return qtdVerdurasPermitidas;
        }
        return 0;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public float getValorBase() { return valorBase; }
}