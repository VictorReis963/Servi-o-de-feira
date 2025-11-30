package model;

import java.time.LocalDate;
public class Entrega {
    private int id;
    private int idAssinatura;
    private LocalDate dataPrevista;
    private String janela;
    public Entrega(int id, int idAssinatura, LocalDate dataPrevista, String janela) {
        this.id = id; this.idAssinatura = idAssinatura; this.dataPrevista = dataPrevista; this.janela = janela;
    }
    public int getId() { return id; }
    public int getIdAssinatura() { return idAssinatura; }
    public LocalDate getDataPrevista() { return dataPrevista; }
    public String getJanela() { return janela; }
}
