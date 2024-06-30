import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилию Имя Отчество дата рождения номер телефона пол:");
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        try {
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных. Требуется ввести 6 параметров.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}") || !phoneNumber.matches("\\d+") || !gender.matches("[fm]")) {
                throw new IllegalArgumentException("Неверный формат данных.");
            }

            writeToFile(lastName, String.join("", data));

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", true))) {
            writer.write(content);
            writer.newLine();
        }
    }
}

