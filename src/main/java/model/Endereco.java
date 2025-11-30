package model;

public class Endereco {
    private int id;
    private int idAssinatura;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    public Endereco(int id, int idAssinatura, String rua, String numero, String cidade, String cep) {
        this.id = id; this.idAssinatura = idAssinatura; this.rua = rua; this.numero = numero; this.cidade = cidade; this.cep = cep;
    }
    public int getId() { return id; }
    public int getIdAssinatura() { return idAssinatura; }
    public String getRua() { return rua; }
    public String getNumero() { return numero; }
    public String getCidade() { return cidade; }
    public String getCep() { return cep; }
}
