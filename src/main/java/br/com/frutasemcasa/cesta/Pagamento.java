package br.com.frutasemcasa.cesta;

public class Pagamento {
    private float valor;
    private boolean status;

    public Pagamento(float valor) {
        this.valor = valor;
    }

    // Simula a validação de pagamento (Passo 22)
    public boolean processarPagamento(String dadosCartao) {
        // Lógica de simulação: Falha se o número do cartão for "0000"
        if ("0000000000000000".equals(dadosCartao)) {
            this.status = false;
            return false;
        }
        this.status = true;
        return true;
    }
}