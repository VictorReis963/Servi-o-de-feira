package dto;

public class AssinaturaWithOwner {

    public int idAssinatura;
    public String nomeAssinante;
    public String emailAssinante;
    public String protocolo;
    public String status;
    public String dataInicio;

    public AssinaturaWithOwner(
        int idAssinatura,
        String nomeAssinante,
        String emailAssinante,
        String protocolo,
        String status,
        String dataInicio
    ) {
        this.idAssinatura = idAssinatura;
        this.nomeAssinante = nomeAssinante;
        this.emailAssinante = emailAssinante;
        this.protocolo = protocolo;
        this.status = status;
        this.dataInicio = dataInicio;
    }
}
