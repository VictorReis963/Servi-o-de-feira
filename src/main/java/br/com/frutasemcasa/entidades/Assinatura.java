package br.com.frutasemcasa.entidades;

import br.com.frutasemcasa.cesta.Cesta;
import br.com.frutasemcasa.cesta.Pagamento;
import java.util.Date;

public class Assinatura {
    private int id;
    private Date dataInicio;
    private String status; // Ex: "aprovado", "aguardando aprovação"
    private String protocolo; // Passo 24: O sistema emite número de protocolo

    // Associações 1..1
    private Assinante assinante;
    private Plano plano;
    private Endereco endereco;
    private Pagamento pagamento;
    private Cesta cesta;

    public Assinatura(int id, Assinante assinante, Plano plano) {
        this.id = id;
        this.assinante = assinante;
        this.plano = plano;
        this.dataInicio = new Date();
        this.status = "Em Aberto";
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    // Método que simula a validação e processamento de pagamento (Passos 21, 22)
    public boolean processaPagamento(String dadosCartao) {
        this.status = "Aguardando Aprovação"; // Passo 19: Muda o status da compra
        
        // Simulação do pagamento
        if (dadosCartao != null && dadosCartao.length() >= 16) {
            this.pagamento = new Pagamento(plano.getValorBase());
            
            // Simulação de aprovação
            if (pagamento.processarPagamento(dadosCartao)) {
                this.status = "Aprovado"; // Passo 22
                this.cesta.setStatus("Aprovado"); // Passo 22
                this.protocolo = "PROTO-" + id + "-" + new Date().getTime(); // Gera protocolo
                return true;
            }
        }
        this.status = "Recusado";
        return false;
    }

    // Getters
    public String getProtocolo() { return protocolo; }
    public String getStatus() { return status; }
    public Cesta getCesta() { return cesta; }
}