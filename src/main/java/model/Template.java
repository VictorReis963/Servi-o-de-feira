package model;

public class Template {

    private String nome;
    private String corpo;

    public Template(String nome, String corpo) {
        this.nome = nome;
        this.corpo = corpo;
    }

    public String getNome() { return nome; }
    public String getCorpo() { return corpo; }

    // gera texto final com nome do assinante
    public String aplicar(String nomeAssinante) {
        return corpo.replace("{nome}", nomeAssinante);
    }
}
