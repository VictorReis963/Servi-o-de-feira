package dao;

import model.Endereco;
import util.CsvUtils;

import java.util.ArrayList;
import java.util.List;

/*
 dao para endereco

*/
public class EnderecoDAO {

    private final String path = "resources/endereco.csv";

    public EnderecoDAO() {
        CsvUtils.ensureFileWithHeader(path, "id;idAssinatura;rua;numero;cidade;cep");
    }

    public List<Endereco> findAll() {
        List<String[]> rows = CsvUtils.read(path);
        List<Endereco> list = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] c = rows.get(i);
            try {
                int id = Integer.parseInt(c[0]);
                int idAss = Integer.parseInt(c[1]);
                String rua = c[2];
                String numero = c[3];
                String cidade = c[4];
                String cep = c[5];
                list.add(new Endereco(id, idAss, rua, numero, cidade, cep));
            } catch (Exception ignored) {}
        }
        return list;
    }

    public int nextId() {
        List<String[]> rows = CsvUtils.read(path);
        return Math.max(1, rows.size());
    }

    public void save(Endereco e) {
        String line = String.format("%d;%d;%s;%s;%s;%s",
                e.getId(), e.getIdAssinatura(), e.getRua(), e.getNumero(), e.getCidade(), e.getCep());
        CsvUtils.append(path, line);
    }
}
