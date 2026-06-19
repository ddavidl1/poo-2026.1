import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateNamesApp {

    public static void main(String[] args) {
        Set<String> names = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("fim")) {
                break;
            }
            if (!input.isEmpty()) {
                names.add(capitalizeName(input));
            }
        }

        System.out.println();
        System.out.println("Nomes cadastrados:");
        System.out.println(names);

        System.out.println();
        System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            String query = scanner.nextLine().trim();
            if (query.equalsIgnoreCase("sair")) {
                break;
            }
            if (query.isEmpty()) {
                System.out.println("Digite um nome válido ou 'sair' para encerrar.");
                continue;
            }
            boolean found = names.contains(capitalizeName(query));
            System.out.println(found ? "Nome encontrado." : "Nome não encontrado.");
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    private static String capitalizeName(String name) {
        if (name.isBlank()) {
            return name;
        }
        String lower = name.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
