package dao;
import model.Cesta;
import util.CsvUtils;
import java.util.*;
public class CestaDAO {
    private final String path = "resources/cesta.csv";
    public CestaDAO() { CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;semanaReferencia;status"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(Cesta c) {
        String[] cols = { String.valueOf(c.getId()), String.valueOf(c.getIdAssinatura()), String.valueOf(c.getSemanaReferencia()), c.getStatus() };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
