import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PurchasesReportApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java PurchasesReportApp <arquivo_entrada> <arquivo_saida>");
            return;
        }

        Path input = Paths.get(args[0]);
        Path output = Paths.get(args[1]);

        List<String> clients = new ArrayList<>();
        List<Double> totals = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(input, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line == null) continue;
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;

                String[] parts = trimmed.split(",", -1);
                if (parts.length < 3) {
                    // ignorar linha malformada
                    continue;
                }

                String name = parts[0].trim();
                String valueText = parts[2].trim();

                double value;
                try {
                    value = Double.parseDouble(valueText);
                } catch (NumberFormatException e) {
                    // ignorar conversão inválida
                    continue;
                }

                int idx = clients.indexOf(name);
                if (idx == -1) {
                    clients.add(name);
                    totals.add(value);
                } else {
                    totals.set(idx, totals.get(idx) + value);
                }
            }

            // preparar linhas de saída
            List<String> outLines = new ArrayList<>();
            for (int i = 0; i < clients.size(); i++) {
                outLines.add(clients.get(i) + ": " + totals.get(i));
            }

            Files.write(output, outLines, StandardCharsets.UTF_8);
            System.out.println("Relatório gravado em: " + output.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao ler ou gravar arquivos: " + e.getMessage());
        }
    }
}
