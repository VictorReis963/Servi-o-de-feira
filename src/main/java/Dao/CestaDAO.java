package dao;

import model.Cesta;
import util.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class CestaDAO {

    private static final String FILE = "resources/cesta.csv";

    public void save(Cesta c) {
        String[] linha = {
            String.valueOf(c.getId()),
            String.valueOf(c.getSemanaReferencia()),
            c.getStatus()
        };

        CsvUtils.appendLine(FILE, linha);
    }
}
