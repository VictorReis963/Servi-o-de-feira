package model;

public class Assinatura {

    private int idAssinatura;
    private int idPlano;
    private int idCesta;
    private int idPagamento;
    private int idEntrega;
    private int idTermo;
    private int idConsentimento;

    private String dataInicio;
    private String status;
    private String protocolo;

    public Assinatura(int idPlano, String dataInicio, String status, String protocolo) {
        this.idPlano = idPlano;
        this.dataInicio = dataInicio;
        this.status = status;
        this.protocolo = protocolo;
    }

    public int getIdAssinatura() { return idAssinatura; }
    public void setIdAssinatura(int idAssinatura) { this.idAssinatura = idAssinatura; }

    public int getIdPlano() { return idPlano; }

    public int getIdCesta() { return idCesta; }
    public void setIdCesta(int idCesta) { this.idCesta = idCesta; }

    public int getIdPagamento() { return idPagamento; }
    public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }

    public int getIdEntrega() { return idEntrega; }
    public void setIdEntrega(int idEntrega) { this.idEntrega = idEntrega; }

    public int getIdTermo() { return idTermo; }
    public void setIdTermo(int idTermo) { this.idTermo = idTermo; }

    public int getIdConsentimento() { return idConsentimento; }
    public void setIdConsentimento(int idConsentimento) { this.idConsentimento = idConsentimento; }

    public String getDataInicio() { return dataInicio; }
    public String getStatus() { return status; }
    public String getProtocolo() { return protocolo; }
}
