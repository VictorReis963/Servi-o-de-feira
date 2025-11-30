package model;

public class Pagamento {
    private int id;
    private int idAssinatura;
    private float valor;
    private String status;
    private String transacao;
    public Pagamento(int id, int idAssinatura, float valor, String status, String transacao) {
        this.id = id; this.idAssinatura = idAssinatura; this.valor = valor; this.status = status; this.transacao = transacao;
    }
    public int getId() { return id; }
    public int getIdAssinatura() { return idAssinatura; }
    public float getValor() { return valor; }
    public String getStatus() { return status; }
    public String getTransacao() { return transacao; }
}
