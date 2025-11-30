package dao;

import model.Termo;
import util.CsvUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 dao para termo

*/
public class TermoDAO {

    private final String path = "resources/termo.csv";

    public TermoDAO() {
        CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;templateId;creationDateTime");
    }

    public List<Termo> findAll() {
        List<String[]> rows = CsvUtils.read(path);
        List<Termo> list = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] c = rows.get(i);
            try {
                int id = Integer.parseInt(c[0]);
                int idAss = Integer.parseInt(c[1]);
                int templateId = Integer.parseInt(c[2]);
                LocalDateTime dt = LocalDateTime.parse(c[3]);
                list.add(new Termo(id, idAss, templateId, dt));
            } catch (Exception ignored) {}
        }
        return list;
    }

    public int nextId() {
        List<String[]> rows = CsvUtils.read(path);
        return Math.max(1, rows.size());
    }

    public void save(Termo t) {
        String line = String.format("%d;%d;%d;%s",
                t.getId(), t.getIdAssinatura(), t.getTemplateId(), t.getCreationDateTime().toString());
        CsvUtils.append(path, line);
    }
}
