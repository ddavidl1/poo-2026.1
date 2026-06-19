public class PhoneApp {

    public static void main(String[] args) {
        try {
            new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Phone("Motorola", "12345");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            Phone phone = new Phone("Samsung", "1234567890123456");
            System.out.println("Phone criado com sucesso: " + phone.getName() + " - " + phone.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
