package dao;

import model.Consentimento;
import util.CsvUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 dao para consentimento
*/
public class ConsentimentoDAO {

    private final String path = "resources/consentimento.csv";

    public ConsentimentoDAO() {
        CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;data;status");
    }

    public List<Consentimento> findAll() {
        List<String[]> rows = CsvUtils.read(path);
        List<Consentimento> list = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] c = rows.get(i);
            try {
                int id = Integer.parseInt(c[0]);
                int idAss = Integer.parseInt(c[1]);
                LocalDate d = LocalDate.parse(c[2]);
                String status = c[3];
                list.add(new Consentimento(id, idAss, d, status));
            } catch (Exception ignored) {}
        }
        return list;
    }

    public int nextId() {
        List<String[]> rows = CsvUtils.read(path);
        return Math.max(1, rows.size());
    }

    public void save(Consentimento c) {
        String line = String.format("%d;%d;%s;%s",
                c.getId(), c.getIdAssinatura(), c.getData().toString(), c.getStatus());
        CsvUtils.append(path, line);
    }
}
