package util;

import java.io.*;
import java.util.*;

public class CsvUtils {

    // le todo o csv e retorna lista de arrays (cada array = colunas)
    public static List<String[]> read(String path) {
        List<String[]> rows = new ArrayList<>();
        File f = new File(path);
        if (!f.exists()) return rows; // arquivo pode nao existir ainda

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                // evita linhas vazias
                if (line.trim().isEmpty()) continue;
                rows.add(line.split(";", -1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    // append sem cabecalho (adiciona linha no final)
    public static void append(String path, String line) {
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // escreve cabecalho se o arquivo nao existir
    public static void ensureFileWithHeader(String path, String header) {
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            if (!f.exists()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                    bw.write(header);
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
