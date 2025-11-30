package dao;

import model.Plano;
import util.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class PlanoDAO {

    private static final String FILE = "resources/planos.csv";

    public List<Plano> loadAll() {
        List<Plano> planos = new ArrayList<>();

        List<String[]> linhas = CsvUtils.readCsv(FILE);

        for (String[] col : linhas) {

            int id = Integer.parseInt(col[0]);
            String nome = col[1];
            int qtdFrutas = Integer.parseInt(col[2]);
            int qtdLegumes = Integer.parseInt(col[3]);
            float precoSemanal = Float.parseFloat(col[4]);

            planos.add(new Plano(id, nome, qtdFrutas, qtdLegumes, precoSemanal));
        }

        return planos;
    }
}
