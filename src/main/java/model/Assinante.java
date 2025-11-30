package model;

public class Assinante {

    private String nome;
    private String celular;
    private String email;

    public Assinante(String nome, String celular, String email) {
        this.nome = nome;
        this.celular = celular;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getCelular() { return celular; }
    public String getEmail() { return email; }

    public String getDados() {
        return nome + " - " + email;
    }
}
