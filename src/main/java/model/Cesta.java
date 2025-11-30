package model;

public class Cesta {
    private int id;
    private int idAssinatura;
    private int semanaReferencia;
    private String status;
    public Cesta(int id, int idAssinatura, int semanaReferencia, String status) {
        this.id = id; this.idAssinatura = idAssinatura; this.semanaReferencia = semanaReferencia; this.status = status;
    }
    public int getId() { return id; }
    public int getIdAssinatura() { return idAssinatura; }
    public int getSemanaReferencia() { return semanaReferencia; }
    public String getStatus() { return status; }
}
