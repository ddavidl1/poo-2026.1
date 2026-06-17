import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {

    /**
     * Método principal da aplicação.
     * 
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Carregar arquivo db.properties
        Properties props = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar db.properties: " + e.getMessage());
            return;
        }

        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPassword = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        // Consulta SQL
        String query = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

        // Armazena atores em um ArrayList
        ArrayList<ActorExport> actors = new ArrayList<>();

        // Conecta ao banco de dados e executa
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                ActorExport actor = new ActorExport(id, firstName, lastName);
                actors.add(actor);
            }

            System.out.println("Total de atores carregados: " + actors.size());

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar consulta: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Gravar o arquivo CSV
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Id,Nome,Sobrenome\n");

            // Escrever dados de cada ator
            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.write("\n");
            }

            System.out.println("Arquivo CSV gerado com sucesso: " + csvPath);

        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
