package dao;
import model.Consentimento;
import util.CsvUtils;
import java.util.*;
public class ConsentimentoDAO {
    private final String path = "resources/consentimento.csv";
    public ConsentimentoDAO() { CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;data;status"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(Consentimento c) {
        String[] cols = { String.valueOf(c.getId()), String.valueOf(c.getIdAssinatura()), c.getData().toString(), c.getStatus() };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
