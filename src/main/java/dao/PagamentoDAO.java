package dao;
import model.Pagamento;
import util.CsvUtils;
import java.util.*;
public class PagamentoDAO {
    private final String path = "resources/pagamento.csv";
    public PagamentoDAO() { CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;valor;status;transacao"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(Pagamento p) {
        String[] cols = { String.valueOf(p.getId()), String.valueOf(p.getIdAssinatura()), String.format("%.2f", p.getValor()), p.getStatus(), p.getTransacao() };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
