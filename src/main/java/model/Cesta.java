package model;

public class Cesta {

    private int idCesta;
    private int idAssinante;
    private int idPlano;
    private String dataCriacao;

    public Cesta(int idAssinante, int idPlano, String dataCriacao) {
        this.idAssinante = idAssinante;
        this.idPlano = idPlano;
        this.dataCriacao = dataCriacao;
    }

    public int getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(int idCesta) {
        this.idCesta = idCesta;
    }

    public int getIdAssinante() {
        return idAssinante;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }
}
