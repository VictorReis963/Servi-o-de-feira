package dao;
import model.Plano;
import util.CsvUtils;
import java.util.*;
public class PlanoDAO {
    private final String path = "resources/planos.csv";
    public List<Plano> loadAll() {
        List<Plano> out = new ArrayList<>();
        List<String[]> rows = CsvUtils.read(path);
        if (rows.size() <= 1) return out;
        for (int i = 1; i < rows.size(); i++) {
            String[] r = rows.get(i);
            try {
                int id = Integer.parseInt(r[0]);
                String nome = r[1];
                float valor = Float.parseFloat(r[2]);
                int f = Integer.parseInt(r[3]);
                int l = Integer.parseInt(r[4]);
                int v = Integer.parseInt(r[5]);
                out.add(new Plano(id, nome, valor, f, l, v));
            } catch (Exception e) { /* pula linha invalida */ }
        }
        return out;
    }
    public Plano findById(int id) {
        return loadAll().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
