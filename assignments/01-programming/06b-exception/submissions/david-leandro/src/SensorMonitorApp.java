import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        int validReadings = 0;
        int invalidReadings = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite as leituras no formato SENSOR_ID;TEMPERATURA_EM_CELSIUS. Digite FIM para encerrar.");
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("FIM")) {
                    break;
                }
                try {
                    monitor.addReading(line);
                    validReadings++;
                } catch (InvalidReadingException e) {
                    System.out.println(e.getMessage());
                    invalidReadings++;
                }
            }

            System.out.printf("Leituras válidas: %d%n", validReadings);
            System.out.printf("Leituras inválidas ignoradas: %d%n", invalidReadings);

            System.out.println("Informe o sensor para consultar a média:");
            String sensorId = scanner.nextLine().trim();
            try {
                double average = monitor.averageFor(sensorId);
                System.out.printf("Temperatura média do sensor %s: %.2f°C%n", sensorId, average);
            } catch (SensorNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}
