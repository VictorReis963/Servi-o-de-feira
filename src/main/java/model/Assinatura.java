package model;

import java.util.Date;
import java.util.UUID;

public class Assinatura {

    private int id;
    private Date dataInicio;
    private String status;
    private String protocolo;

    public Assinatura(int id, Date dataInicio, String status) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.status = status;
        this.protocolo = UUID.randomUUID().toString().substring(0, 8);
    }

    public int getId() { return id; }
    public Date getDataInicio() { return dataInicio; }
    public String getStatus() { return status; }
    public String getProtocolo() { return protocolo; }
}
