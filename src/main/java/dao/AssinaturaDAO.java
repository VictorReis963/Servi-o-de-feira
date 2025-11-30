package dao;

import model.Assinatura;
import util.CsvUtils;

public class AssinaturaDAO {

    private static final String FILE = "resources/assinatura.csv";

    public void save(Assinatura a) {

        String[] l = {
                String.valueOf(a.getId()),
                a.getStatus(),
                a.getDataInicio().toString(),
                a.getProtocolo()
        };

        CsvUtils.appendLine(FILE, l);
    }
}
