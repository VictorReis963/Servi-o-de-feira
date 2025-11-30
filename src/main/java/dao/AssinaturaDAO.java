package dao;
import model.Assinante;
import model.Assinatura;
import util.CsvUtils;
import java.util.*;
import java.time.LocalDate;
public class AssinaturaDAO {
    private final String path = "resources/assinatura.csv";
    public AssinaturaDAO() { CsvUtils.ensureFileWithHeader(path, "id;nome;email;status;protocolo;dataInicio"); }
    public int nextId() { List<String[]> r = CsvUtils.read(path); return Math.max(1, r.size()); }
    public void save(Assinatura a) {
        String[] cols = { String.valueOf(a.getId()), a.getNomeAssinante(), a.getEmail(), a.getStatus(), a.getProtocolo(), a.getDataInicio().toString() };
        CsvUtils.appendLine(path, CsvUtils.joinWithSemicolon(cols));
    }
}
