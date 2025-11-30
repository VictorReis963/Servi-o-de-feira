package model;

public class Pagamento {

    private float valor;
    private String status;
    private Cartao cartao;

    public Pagamento(float valor, String status, Cartao cartao) {
        this.valor = valor;
        this.status = status;
        this.cartao = cartao;
    }

    public float getValor() { return valor; }
    public String getStatus() { return status; }
    public Cartao getCartao() { return cartao; }
}
