import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("result.txt", false);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для поиска:");
        String sear = scanner.nextLine();
        System.out.println("Введите путь:");
        String path = scanner.next();

        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(sear)) {
                writer.write(lines.get(i) + "\n");
                System.out.println("Найдено в строке: " + i);
            }
        }
        writer.close();
    }

}
