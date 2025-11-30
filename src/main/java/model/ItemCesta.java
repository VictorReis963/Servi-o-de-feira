package model;

public class ItemCesta {
    private int id;
    private int idCesta;
    private int idProduto;
    private int quantidade;
    public ItemCesta(int id, int idCesta, int idProduto, int quantidade) {
        this.id = id; this.idCesta = idCesta; this.idProduto = idProduto; this.quantidade = quantidade;
    }
    public int getId() { return id; }
    public int getIdCesta() { return idCesta; }
    public int getIdProduto() { return idProduto; }
    public int getQuantidade() { return quantidade; }
}
