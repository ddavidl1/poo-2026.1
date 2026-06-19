import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IDPFlixApp {
    // Ajuste estes parâmetros para seu ambiente de banco de dados
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public static void main(String[] args) {
        Path input = Paths.get("..", "data", "new_films.txt");
        if (args.length >= 1) {
            input = Paths.get(args[0]);
        }

        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(input);
            boolean first = true;
            for (String line : lines) {
                if (line == null) continue;
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;
                // pular cabeçalho se houver
                if (first && trimmed.toLowerCase().startsWith("title")) {
                    first = false;
                    continue;
                }
                first = false;
                String[] parts = trimmed.split(";", -1);
                if (parts.length < 5) continue; // ignorar malformadas
                String title = parts[0].trim();
                int languageId;
                int rentalDuration;
                double rentalRate;
                double replacementCost;
                try {
                    languageId = Integer.parseInt(parts[1].trim());
                    rentalDuration = Integer.parseInt(parts[2].trim());
                    rentalRate = Double.parseDouble(parts[3].trim());
                    replacementCost = Double.parseDouble(parts[4].trim());
                } catch (NumberFormatException e) {
                    // ignorar linha com dados inválidos
                    continue;
                }
                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de filmes: " + e.getMessage());
            return;
        }

        if (films.isEmpty()) {
            System.out.println("Nenhum filme para importar.");
            return;
        }

        // Conectar ao banco e executar operações
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false);

            // Inserir filmes
            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                for (Film f : films) {
                    ps.setString(1, f.getTitle());
                    ps.setInt(2, f.getLanguageId());
                    ps.setInt(3, f.getRentalDuration());
                    ps.setDouble(4, f.getRentalRate());
                    ps.setDouble(5, f.getReplacementCost());
                    ps.addBatch();
                }
                ps.executeBatch();
            }

            // Atualizar rental_rate em 10%
            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                int updated = ps.executeUpdate();
                System.out.println("Registros atualizados (rental_rate * 1.1): " + updated);
            }

            // Listar filmes com rental_duration = 99
            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement ps = conn.prepareStatement(selectSql);
                 ResultSet rs = ps.executeQuery()) {
                System.out.println("Filmes com rental_duration = 99:");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rate = rs.getDouble("rental_rate");
                    System.out.printf("%s -> %.2f%n", title, rate);
                }
            }

            conn.commit();
        } catch (SQLException e) {
            System.out.println("Erro de banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
