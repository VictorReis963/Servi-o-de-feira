package dao;
import model.Produto;
import util.CsvUtils;
import java.util.*;
public class ProdutoDAO {
    private final String path = "resources/produtos.csv";
    // carrega todos os produtos, normalizando tipo para FRUTA/LEGUME
    public List<Produto> loadAll() {
        List<Produto> out = new ArrayList<>();
        List<String[]> rows = CsvUtils.read(path);
        if (rows.size() <= 1) return out;
        for (int i = 1; i < rows.size(); i++) {
            String[] r = rows.get(i);
            if (r.length < 3) continue;
            try {
                int id = Integer.parseInt(r[0]);
                String nome = r[1];
                String tipoRaw = r[2].toLowerCase();
                String tipo = tipoRaw.contains("fruta") ? "FRUTA" : "LEGUME";
                out.add(new Produto(id, nome, tipo));
            } catch (Exception e) { /* pula linha invalida */ }
        }
        return out;
    }
    public Produto findById(int id) {
        return loadAll().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
