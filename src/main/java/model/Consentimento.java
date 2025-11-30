package model;

import java.time.LocalDate;
public class Consentimento {
    private int id;
    private int idAssinatura;
    private LocalDate data;
    private String status;
    public Consentimento(int id, int idAssinatura, LocalDate data, String status) {
        this.id = id; this.idAssinatura = idAssinatura; this.data = data; this.status = status;
    }
    public int getId() { return id; }
    public int getIdAssinatura() { return idAssinatura; }
    public LocalDate getData() { return data; }
    public String getStatus() { return status; }
}
