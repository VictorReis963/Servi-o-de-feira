package model;

public class Plano {
    private int id;
    private String nome;
    private float valorBase;
    private int qtdFrutas;
    private int qtdLegumes;
    private int qtdVerduras;

    public Plano(int id, String nome, float valorBase, int qtdFrutas, int qtdLegumes, int qtdVerduras) {
        this.id = id; this.nome = nome; this.valorBase = valorBase;
        this.qtdFrutas = qtdFrutas; this.qtdLegumes = qtdLegumes; this.qtdVerduras = qtdVerduras;
    }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public float getValorBase() { return valorBase; }
    public int getQtdFrutas() { return qtdFrutas; }
    public int getQtdLegumes() { return qtdLegumes; }
    public int getQtdVerduras() { return qtdVerduras; }
}
