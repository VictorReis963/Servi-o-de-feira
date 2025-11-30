package model;

public class Cartao {

    private String numero;
    private String validade;
    private String nomeTitular;

    public Cartao(String numero, String validade, String nomeTitular) {
        this.numero = numero;
        this.validade = validade;
        this.nomeTitular = nomeTitular;
    }

    public String getNumero() { return numero; }
    public String getValidade() { return validade; }
    public String getNomeTitular() { return nomeTitular; }
}
