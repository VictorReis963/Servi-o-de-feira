package dto;

import java.util.ArrayList;
import java.util.List;

/*
 dto simples que carrega os dados necessarios para criar uma assinatura
*/
public class AssinaturaDTO {
    public String assinanteNome;
    public String email;
    public int planoId;
    public String cartao; // numero simplificado
    public List<ItemDTO> itens = new ArrayList<>();

    public void addItem(String tipo, int quantidade, int produtoId) {
        itens.add(new ItemDTO(tipo, quantidade, produtoId));
    }

    public static class ItemDTO {
        public String tipo;
        public int quantidade;
        public int produtoId;
        public ItemDTO(String tipo, int quantidade, int produtoId) {
            this.tipo = tipo;
            this.quantidade = quantidade;
            this.produtoId = produtoId;
        }
    }
}
