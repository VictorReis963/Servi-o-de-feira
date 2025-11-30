package model;

public class ItemCesta {

    private int idCesta;
    private int idProduto;
    private int quantidade;

    public ItemCesta(int idCesta, int idProduto, int quantidade) {
        this.idCesta = idCesta;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getIdCesta() {
        return idCesta;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
