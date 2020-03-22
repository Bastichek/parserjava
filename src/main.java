import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class main {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("result.txt", false);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для поиска:");
        String sear = scanner.nextLine();
        System.out.println("Введите путь:");
        String path = scanner.next();

        List<Path> files = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        for (int i = 0; i < files.size(); i++) {
            List<String> lines = Files.readAllLines(files.get(i), StandardCharsets.UTF_8);
            for (int j = 0; j < lines.size(); j++) {
                if (lines.get(j).contains(sear)) {
                    writer.write(lines.get(j) + "\n");
                    System.out.println("Найдено в строке: " + j);
                }
            }
        }
        writer.close();
    }

}
