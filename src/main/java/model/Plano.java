package model;

public class Plano {

    private int id;
    private String nome;
    private int qtdFrutas;
    private int qtdLegumes;
    private float precoSemanal;

    public Plano(int id, String nome, int qtdFrutas, int qtdLegumes, float precoSemanal) {
        this.id = id;
        this.nome = nome;
        this.qtdFrutas = qtdFrutas;
        this.qtdLegumes = qtdLegumes;
        this.precoSemanal = precoSemanal;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQtdFrutas() { return qtdFrutas; }
    public int getQtdLegumes() { return qtdLegumes; }
    public float getPrecoSemanal() { return precoSemanal; }
}
