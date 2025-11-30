package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
 util para ler/escrever csv de forma robusta
 - detecta separador: , ; ou tab
 - trima campos
 
*/
public class CsvUtils {

    // le todo o arquivo e retorna lista de colunas por linha
    public static List<String[]> read(String path) {
        List<String[]> rows = new ArrayList<>();
        File f = new File(path);
        if (!f.exists()) return rows;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String header = br.readLine();
            if (header == null) return rows;
            String sep = detectSeparator(header);
            rows.add(splitAndTrim(header, sep));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                rows.add(splitAndTrim(line, sep));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    // detecta separador principal numa linha
    private static String detectSeparator(String line) {
        if (line.contains("\t")) return "\\t";
        if (line.contains(";")) return ";";
        if (line.contains(",")) return ",";
        // fallback: whitespace
        return "\\s+";
    }

    private static String[] splitAndTrim(String line, String sep) {
        String[] parts = line.split(sep, -1);
        for (int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
        return parts;
    }

    // garante arquivo com header
    public static void ensureFileWithHeader(String path, String header) {
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            if (!f.exists()) {
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), StandardCharsets.UTF_8))) {
                    bw.write(header);
                    bw.newLine();
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // append de uma linha ja formatada (col1;col2;col3)
    public static void appendLine(String path, String line) {
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), StandardCharsets.UTF_8))) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // join com ; e escapa ponto e virgula se necessario
    public static String joinWithSemicolon(String[] cols) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i > 0) sb.append(";");
            sb.append(cols[i] == null ? "" : cols[i]);
        }
        return sb.toString();
    }
}
