package dao;

import model.Pagamento;
import util.CsvUtils;

import java.util.ArrayList;
import java.util.List;

/*
 dao para pagamento
 header: id;idAssinatura;valor;status;transacao
*/
public class PagamentoDAO {

    private final String path = "resources/pagamento.csv";

    public PagamentoDAO() {
        CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;valor;status;transacao");
    }

    public List<Pagamento> findAll() {
        List<String[]> rows = CsvUtils.read(path);
        List<Pagamento> list = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] c = rows.get(i);
            try {
                int id = Integer.parseInt(c[0]);
                int idAss = Integer.parseInt(c[1]);
                float valor = Float.parseFloat(c[2]);
                String status = c[3];
                String transacao = c[4];
                list.add(new Pagamento(id, idAss, valor, status, transacao));
            } catch (Exception ignored) {}
        }
        return list;
    }

    public int nextId() {
        List<String[]> rows = CsvUtils.read(path);
        return Math.max(1, rows.size());
    }

    public void save(Pagamento p) {
        String line = String.format("%d;%d;%.2f;%s;%s",
                p.getId(), p.getIdAssinatura(), p.getValor(), p.getStatus(), p.getTransacao());
        CsvUtils.append(path, line);
    }
}
