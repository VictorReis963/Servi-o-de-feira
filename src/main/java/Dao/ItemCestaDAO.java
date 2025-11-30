package dao;

import model.ItemCesta;
import util.CsvUtils;

public class ItemCestaDAO {

    private static final String FILE = "resources/itemcesta.csv";

    public void save(ItemCesta ic) {

        String[] linha = {
                String.valueOf(ic.getIdCesta()),
                String.valueOf(ic.getIdProduto()),
                String.valueOf(ic.getQuantidade())
        };

        CsvUtils.appendLine(FILE, linha);
    }
}
