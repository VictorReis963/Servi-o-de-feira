package model;

import java.util.Date;

public class Entrega {

    private Date dataPrevista;
    private String janelaEntrega;

    public Entrega(Date dataPrevista, String janelaEntrega) {
        this.dataPrevista = dataPrevista;
        this.janelaEntrega = janelaEntrega;
    }

    public Date getDataPrevista() { return dataPrevista; }
    public String getJanelaEntrega() { return janelaEntrega; }
}
