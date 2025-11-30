package model;

public class Produto {

    private int id;
    private String nome;
    private String tipo; // FRUTA ou LEGUME

    public Produto(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
}
