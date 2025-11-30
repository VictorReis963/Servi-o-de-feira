package dao;
import model.Endereco;
import util.CsvUtils;
import java.util.*;
public class EnderecoDAO {
    private final String path = "resources/endereco.csv";
    public EnderecoDAO() { CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;rua;numero;cidade;cep"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(Endereco e) {
        String[] cols = { String.valueOf(e.getId()), String.valueOf(e.getIdAssinatura()), e.getRua(), e.getNumero(), e.getCidade(), e.getCep() };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
