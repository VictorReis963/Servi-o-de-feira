package dao;
import model.ItemCesta;
import util.CsvUtils;
import java.util.*;
public class ItemCestaDAO {
    private final String path = "resources/itemcesta.csv";
    public ItemCestaDAO() { CsvUtils.ensureFileWithHeader(path, "id;idCesta;produtoId;quantidade"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(ItemCesta it) {
        String[] cols = { String.valueOf(it.getId()), String.valueOf(it.getIdCesta()), String.valueOf(it.getIdProduto()), String.valueOf(it.getQuantidade()) };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
