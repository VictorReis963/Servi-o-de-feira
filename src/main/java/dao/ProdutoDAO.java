package dao;

import model.Produto;
import util.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private static final String FILE = "resources/produtos.csv";

    public List<Produto> loadAll() {
        List<Produto> produtos = new ArrayList<>();

        List<String[]> linhas = CsvUtils.readCsv(FILE);

        for (String[] col : linhas) {

            int id = Integer.parseInt(col[0]);
            String nome = col[1];

            // normaliza o tipo
            String tipoOriginal = col[2].trim().toLowerCase();

            String tipo;
            if (tipoOriginal.contains("fruta")) tipo = "FRUTA";
            else tipo = "LEGUME";

            produtos.add(new Produto(id, nome, tipo));
        }

        return produtos;
    }
}
