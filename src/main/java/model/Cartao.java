package model;

public class Cartao {

    private String numero;
    private String validade;
    private String cvv;
    private String nomeImpresso;

    public Cartao(String numero, String validade, String cvv, String nomeImpresso) {
        this.numero = numero;
        this.validade = validade;
        this.cvv = cvv;
        this.nomeImpresso = nomeImpresso;
    }

    public String getNumero() { return numero; }
    public String getValidade() { return validade; }
    public String getCvv() { return cvv; }
    public String getNomeImpresso() { return nomeImpresso; }
}
