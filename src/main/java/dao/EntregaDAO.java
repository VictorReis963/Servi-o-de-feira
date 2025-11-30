package dao;
import model.Entrega;
import util.CsvUtils;
import java.util.*;
public class EntregaDAO {
    private final String path = "resources/entrega.csv";
    public EntregaDAO() { CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;dataPrevista;janelaEntrega"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(Entrega e) {
        String[] cols = { String.valueOf(e.getId()), String.valueOf(e.getIdAssinatura()), e.getDataPrevista().toString(), e.getJanela() };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
