package dao;
import model.Termo;
import util.CsvUtils;
import java.util.*;
public class TermoDAO {
    private final String path = "resources/termo.csv";
    public TermoDAO() { CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;templateId;creationDateTime"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(Termo t) {
        String[] cols = { String.valueOf(t.getId()), String.valueOf(t.getIdAssinatura()), String.valueOf(t.getTemplateId()), t.getCreated().toString() };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
