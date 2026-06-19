import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {

    private final Map<String, List<Double>> readingsBySensor = new HashMap<>();

    public void addReading(String line) throws InvalidReadingException {
        if (line == null || line.trim().isEmpty()) {
            throw new InvalidReadingException("Leitura inválida: linha vazia.");
        }

        String[] parts = line.split(";", -1);
        if (parts.length != 2) {
            throw new InvalidReadingException("Leitura inválida: formato correto é SENSOR_ID;TEMPERATURA_EM_CELSIUS.");
        }

        String sensorId = parts[0].trim();
        String temperatureText = parts[1].trim();

        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("Leitura inválida: o identificador do sensor não pode estar vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(temperatureText);
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Leitura inválida: a temperatura deve ser um número válido.", e);
        }

        if (temperature < -30 || temperature > 55) {
            throw new InvalidReadingException("Leitura inválida: a temperatura deve estar entre -30°C e 55°C.");
        }

        readingsBySensor
            .computeIfAbsent(sensorId, id -> new ArrayList<>())
            .add(temperature);
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        if (sensorId == null || sensorId.trim().isEmpty()) {
            throw new SensorNotFoundException("Consulta inválida: informe um identificador de sensor válido.");
        }

        List<Double> values = readingsBySensor.get(sensorId);
        if (values == null || values.isEmpty()) {
            throw new SensorNotFoundException("Não existem leituras para o sensor informado.");
        }

        double sum = 0;
        for (double temperature : values) {
            sum += temperature;
        }
        return sum / values.size();
    }
}
