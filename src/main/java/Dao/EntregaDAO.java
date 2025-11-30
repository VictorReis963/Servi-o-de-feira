package dao;

import model.Entrega;
import util.CsvUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 dao para entrega

*/
public class EntregaDAO {

    private final String path = "resources/entrega.csv";

    public EntregaDAO() {
        CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;dataPrevista;janelaEntrega");
    }

    public List<Entrega> findAll() {
        List<String[]> rows = CsvUtils.read(path);
        List<Entrega> list = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] c = rows.get(i);
            try {
                int id = Integer.parseInt(c[0]);
                int idAss = Integer.parseInt(c[1]);
                LocalDate d = LocalDate.parse(c[2]);
                String janela = c[3];
                list.add(new Entrega(id, idAss, d, janela));
            } catch (Exception ignored) {}
        }
        return list;
    }

    public int nextId() {
        List<String[]> rows = CsvUtils.read(path);
        return Math.max(1, rows.size());
    }

    public void save(Entrega e) {
        String line = String.format("%d;%d;%s;%s",
                e.getId(), e.getIdAssinatura(), e.getDataPrevista().toString(), e.getJanelaEntrega());
        CsvUtils.append(path, line);
    }
}
