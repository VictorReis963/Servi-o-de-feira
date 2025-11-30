package model;

public class Cesta {

    private int id;
    private int semanaReferencia;
    private String status;

    public Cesta(int id, int semanaReferencia, String status) {
        this.id = id;
        this.semanaReferencia = semanaReferencia;
        this.status = status;
    }

    public int getId() { return id; }
    public int getSemanaReferencia() { return semanaReferencia; }
    public String getStatus() { return status; }
}
