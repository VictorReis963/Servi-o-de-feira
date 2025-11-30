package dto;
import java.util.*;
public class AssinaturaDTO {
    public String nome;
    public String celular;
    public String email;
    public int planoId;
    public List<Item> itens = new ArrayList<>();
    public static class Item {
        public int produtoId;
        public int quantidade;
        public Item(int produtoId, int quantidade) { this.produtoId = produtoId; this.quantidade = quantidade; }
    }
}
